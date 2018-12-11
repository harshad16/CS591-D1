package src.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import src.entities.Assignment;
import src.entities.Course;
import src.service.AssignmentService;

public class AddAssignments extends JPanel {

	private List<Assignment> assignments;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel contentPane;
		
	public AddAssignments(Course course) {
		
		contentPane = new JPanel();
		this.assignments = course.getAssignments();
		setBounds(215, 146, 1021, 527);
		setLayout(null);
		
		String[] columnNames = {"Name",
                "Weight",
                "type",
                "total",
                "Description",
                "Created At"};
		for (Assignment a: this.assignments)
			System.out.println(a);
		Object[][] data = new Object[assignments.size() + 1][columnNames.length];
		for (int i = 0; i < assignments.size(); ++i) {
			System.out.println("Arezoo");
			Assignment a = this.assignments.get(i);
			String description = a.getDescription() != null ? a.getDescription() : "NO Description Avaible";
			Object[] row = {a.getName(), a.getWeight(), a.getType(), a.getTotal(), description, a.getCreatedAt().toLocaleString()};
			System.out.println("Sepideh");
			for (int j = 0; j < row.length; ++j) {
			    data[i][j] = row[j];
			}
		}
		//Add extra row for creating a new assignment
		for (int k = 0; k < columnNames.length; ++k) {
			data[assignments.size()][k] = new String("");
		}
		DefaultTableModel tableModel=new DefaultTableModel(data, columnNames){
			
			// This Method is to make a column not be Editable on Table.
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return (0 <= column  && column < data[0].length &&  0 <= row && row<= data.length) ? true: false; 
		    	
		    }
		    
		    // This Method Renders Checkbox on Table.
		    @Override
		    public Class<?> getColumnClass(int columnIndex) {
		        return getValueAt(0, columnIndex).getClass();
		    }
		}; 
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 32, 960, 422);
		scrollPane.setHorizontalScrollBarPolicy(
				   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		
		table = new JTable(tableModel);
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
 				Integer courseId = course.getId();
 				String name = table.getModel().getValueAt(row, 0).toString();
 				Integer weight =  Integer.parseInt(table.getModel().getValueAt(row, 1).toString());
 				String type = table.getModel().getValueAt(row, 2).toString();
 				Integer total = Integer.parseInt(table.getModel().getValueAt(row, 3).toString());
 				String description = table.getModel().getValueAt(row, 4).toString();
 				
 				Assignment a = new Assignment(courseId,name, weight, description, type, total);
 				//if its not the last row , we need set the assignmentId so we know which one to update
 				if (row != assignments.size() && assignments.size() != 0 ) {
 				   a.setAssignmentId(assignments.get(row).getAssignmentId());
 				}
 				boolean success = saveAssignment(a);
 				if(success) {
				    JOptionPane.showMessageDialog(contentPane, "Success!");	
				}else {
						JOptionPane.showMessageDialog(contentPane, "Error!");	
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
 				Integer courseId = course.getId();
 				String name = table.getModel().getValueAt(row, 0).toString();
 				Integer weight =  (Integer) (table.getModel().getValueAt(row, 1));
 				String type = table.getModel().getValueAt(row, 2).toString();
 				Integer total = (Integer) table.getModel().getValueAt(row, 3);
 				String description = table.getModel().getValueAt(row, 4).toString();
 				Assignment a = new Assignment(courseId,name, weight, description, type, total);
 				//if its not the last row , we need set the assignmentId so we know which one to update
 				a.setAssignmentId(assignments.get(row).getAssignmentId());
 				
 				boolean success = deleteAssignment(a);
 				if(success) {
				    JOptionPane.showMessageDialog(contentPane, "Deleted successfully!");
				}else {
						JOptionPane.showMessageDialog(contentPane, "Error!");	
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
