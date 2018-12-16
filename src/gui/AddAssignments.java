package src.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import src.entities.Assignment;
import src.entities.Course;
import src.service.AssignmentService;

public class AddAssignments extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel contentPane;
	private Course course;
	private List<Assignment> assignments;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	
	
	public AddAssignments(Course c) {
		this.course = c;
		initialize();
	}
	
	public void initialize() {
		AssignmentService asgnService = new AssignmentService();
		try {
			assignments = asgnService.readAssignmentByCID(course.getId());
		} catch (SQLException e1) {
			assignments = course.getAssignments();
		}
		contentPane = new JPanel();
		setBounds(215, 146, 1021, 527);
		setLayout(null);
		
		// Populate Assignments
		String[] columnNames = {"Name","Weight","Total","Type","Description","isOptional","Created At"};
		Object[][] data = new Object[assignments.size()+1][columnNames.length];
		for (int i = 0; i < assignments.size(); ++i) {
			Assignment a = assignments.get(i);
			String description = a.getDescription() != null ? a.getDescription() : "NO Description Avaible";
			Boolean isOptional = a.getIsOptional();
			Object[] row = {a.getName(), a.getWeight(), a.getTotal(), a.getType(), description, isOptional, a.getCreatedAt().toString()};
			for (int j = 0; j < row.length; ++j) {
			    data[i][j] = row[j];
			}
		}
		//Add extra row for creating a new assignment
		for (int k = 0; k < columnNames.length; ++k) {
			if(k==columnNames.length-2) {
				data[assignments.size()][k] = false;
			}else {
				data[assignments.size()][k] = new String("");
			}
				
		}
		
		tableModel=new DefaultTableModel(data, columnNames){	
			private static final long serialVersionUID = 1L;
			// This Method is to make a column not be Editable on Table.
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return (column == data[0].length-1) ? false:true; 
		    	
		    }
		    // This Method Renders Checkbox on Table.
		    @Override
		    public Class<?> getColumnClass(int columnIndex) {
		        return getValueAt(0, columnIndex).getClass();
		    }
		}; 
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 32, 960, 422);
		scrollPane.setHorizontalScrollBarPolicy(
				   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
	
		table = new JTable(tableModel);	
		//set text alignment in table cells for both integer and string
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
		table.setDefaultRenderer(Integer.class, centerRenderer);
		table.setPreferredScrollableViewportSize(new Dimension(400, 400));
		table.getTableHeader().setForeground(SystemColor.textHighlight);
		table.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 16));
		table.getTableHeader().setReorderingAllowed(false);
		Dimension d = table.getTableHeader().getPreferredSize();
		d.height = 30;
		table.getTableHeader().setSize(d);
		
		table.setFillsViewportHeight(true);
		table.setRowHeight(30);
		table.setFont(new Font("Georgia", Font.PLAIN, 16));
		
		scrollPane.setViewportView(table);

			
		JButton  saveBtn = new JButton("Save");
		saveBtn.setBounds(755, 485, 97, 25);
		add(saveBtn);
		saveBtn.addActionListener(new ActionListener() {
 			@Override
			public void actionPerformed(ActionEvent e) {
 				//Assignment a = new Assignment();
 				int row = table.getSelectedRow();
 				if(row == -1) {
					JOptionPane.showMessageDialog(AddAssignments.this, "Please Select a Row to Save!");
				}else {
	 				Integer courseId = course.getId();
	 				String name = table.getModel().getValueAt(row, 0).toString();
	 				Integer weight =  Integer.parseInt(table.getModel().getValueAt(row, 1).toString());
	 				String type = table.getModel().getValueAt(row, 3).toString();
	 				Integer total = Integer.parseInt(table.getModel().getValueAt(row, 2).toString());
	 				String description = table.getModel().getValueAt(row, 4).toString();
	 				Boolean isOptional = (Boolean) table.getModel().getValueAt(row, 5);
	 				
	 				if(weightcheck(weight)) {
		 				Assignment a = new Assignment(courseId,name, weight, description, type, total, isOptional);
		 				//if its not the last row , we need set the assignmentId so we know which one to update
		 				if (row != assignments.size() && assignments.size() != 0 ) {
		 				   a.setAssignmentId(assignments.get(row).getAssignmentId());
		 				}
		 				boolean success = saveAssignment(a);
		 				if(success) {
						    JOptionPane.showMessageDialog(AddAssignments.this, "Success!");
						}else {
							JOptionPane.showMessageDialog(AddAssignments.this, "Error!");	
						}
		 				// Refresh the Add Assignment
		 				// initialize();
	 				}else {
	 					JOptionPane.showMessageDialog(AddAssignments.this, "Total Weight for course is more then 100%!");
	 				}
				}
	 		}

			private boolean weightcheck(Integer weight) {
				// TODO Auto-generated method stub
				Integer total_wgt = 0;
				for(Assignment a: assignments) {
					total_wgt+= a.getWeight();
				}
				if (total_wgt+weight<=100) {
					return true;
				}else {
					return false;
				}
			}
		});
			
		JButton deleteBtn = new JButton("delete");
		deleteBtn.setBounds(864, 485, 97, 25);
		add(deleteBtn);
		deleteBtn.addActionListener(new ActionListener() {					
 			@Override
			public void actionPerformed(ActionEvent e) {
 				//Assignment a = new Assignment();
 				int row = table.getSelectedRow();
 				if(row == -1) {
					JOptionPane.showMessageDialog(AddAssignments.this, "Please Select a Row to Save!");
				}else {	
	 				Integer courseId = course.getId();
	 				String name = table.getModel().getValueAt(row, 0).toString();
	 				Integer weight =  (Integer) (table.getModel().getValueAt(row, 1));
	 				String type = table.getModel().getValueAt(row, 3).toString();
	 				Integer total = (Integer) table.getModel().getValueAt(row, 2);
	 				String description = table.getModel().getValueAt(row, 4).toString();
	 				Boolean isOptional = (Boolean) table.getModel().getValueAt(row, 5);
	 				Assignment a = new Assignment(courseId,name, weight, description, type, total, isOptional);
	 				//if its not the last row , we need set the assignmentId so we know which one to update
	 				boolean success=false;
	 				if(assignments.size()<row) {
	 					a.setAssignmentId(assignments.get(row).getAssignmentId());
	 					success = deleteAssignment(a);
	 				}
					if(success) {
					    JOptionPane.showMessageDialog(contentPane, "Deleted successfully!");
					}else {
							JOptionPane.showMessageDialog(contentPane, "Error!");	
					}
	 			 }
 			}
		});
	}
	
	private boolean saveAssignment(Assignment a) {
	    try {
	    	AssignmentService assignmentService = new AssignmentService();
	    	assignmentService.saveAssignment(a);
	    } catch (SQLException e) {
		    return false;
	    }
	    return true;
    }
	
	private boolean deleteAssignment(Assignment a) {
	    try {
	    	AssignmentService assignmentService = new AssignmentService();
	    	assignmentService.deleteAssignment(a);
	    } catch (SQLException e) {
		    return false;
	    }
	    return true;
    }
	
}
