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

import src.entities.Assignment;
import src.entities.Course;
import src.service.AssignmentService;
import src.service.CourseService;

public class AddAssignments extends JPanel {

	private List<Assignment> assignments;
	/**
	 * Create the panel.
	 */
	
		
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
		
		tableModel.addRow(new Object[]{"...", "...", "...","..."});
		JTable resultTable = new JTable(tableModel);
		resultTable.setPreferredScrollableViewportSize(new Dimension(400, 400));
		resultTable.getTableHeader().setForeground(SystemColor.textHighlight);
		resultTable.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 16));
		resultTable.getTableHeader().setReorderingAllowed(false);
		Dimension d = resultTable.getTableHeader().getPreferredSize();
		d.height = 30;
		resultTable.getTableHeader().setSize(d);

		resultTable.setFillsViewportHeight(true);
		resultTable.setRowHeight(30);
		resultTable.setFont(new Font("Georgia", Font.PLAIN, 16));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 145, 905, 297);
		add(scrollPane);

		scrollPane.setViewportView(resultTable);
		
		scrollPane.setViewportView(resultTable);

		//JTable table = new JTable(data, columnNames);
		//table.setBounds(12, 40, 949, 459);
		//add(new JScrollPane(table));
		//add(table);
			
		JButton  saveBtn = new JButton("Save");
		saveBtn.setBounds(755, 485, 97, 25);
		add(saveBtn);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.setBounds(864, 485, 97, 25);
		add(clearBtn);
	}

}
