package src.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
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

import src.entities.Assignment;
import src.entities.Course;
import src.service.AssignmentService;
import src.service.CourseService;

public class AddAssignments extends JPanel {

	private List<Assignment> assignments;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
		
	public AddAssignments(Course course) {
		
		this.assignments = course.getAssignments();
		setBounds(215, 146, 1021, 527);
		setLayout(null);
		
		String[] columnNames = {"Name",
                "Weight",
                "Description",
                "Created At"};
		
		Object[][] data = new Object[assignments.size()][columnNames.length];
		for (int i = 0; i < data.length; ++i) {
			Assignment a = this.assignments.get(i);
			String description = a.getDescription() != null ? a.getDescription() : "NO Description Avaible";
			Object[] row = {a.getName(), a.getWeight(), description, a.getCreatedAt().toLocaleString()};
			for (int j = 0; j < row.length; ++j) {
			    data[i][j] = row[j];
			}
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
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.setBounds(864, 485, 97, 25);
		add(clearBtn);
	}
	
}
