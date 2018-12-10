package src.gui;

import src.entities.Student;
import src.service.StudentService;
import java.sql.SQLException;
import java.util.List;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class AddStudentToCourse extends JPanel {
	private JTextField searchText;
	private String searchType;
	private List<Student> students;
	private Object[][] rst;
	private JScrollPane scrollPane;
	private Student selectedStudent;
	private JTable resultTable;
	
	/**
	 * Create the panel.
	 */
	public AddStudentToCourse() {
		setBounds(215, 146, 1021, 527);
		setLayout(null);
		
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("Georgia", Font.PLAIN, 14));
		saveButton.setHorizontalAlignment(SwingConstants.LEFT);
		saveButton.setBounds(755, 473, 113, 37);
		add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO: Store the selected student to classes and course database
				for (int row = 0; row < resultTable.getRowCount(); row++){
			        for ( int col=0; col < resultTable.getColumnCount(); col++) {
			        	if ((resultTable.getValueAt(row, resultTable.getColumnCount()-1).toString()== "true")) {
			        		System.out.println(resultTable.getValueAt(row, col));
			        	}
			        }
			    }
			}
		});

		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
				model.setRowCount(0);
				searchText.setText("");
			}
		});
		clearButton.setBounds(901, 473, 97, 37);
		clearButton.setFont(new Font("Georgia", Font.PLAIN, 14));
		add(clearButton);
		
		searchText = new JTextField();
		searchText.setBounds(214, 50, 518, 37);
		add(searchText);
		searchText.setColumns(10);
		
		JLabel searchLabel = new JLabel("Search :");
		searchLabel.setIcon(new ImageIcon(AddStudentToCourse.class.getResource("/src/misc/search_32x32.png")));
		searchLabel.setFont(new Font("Georgia", Font.PLAIN, 16));
		searchLabel.setBounds(93, 49, 109, 37);
		add(searchLabel);
		
		String[] category = {"BUid", "First Name", "Last Name"};
		JComboBox<String> comboBox = new JComboBox(category);
		searchType = "BUid";
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//store search filter 
				searchType = (String)comboBox.getSelectedItem();
			}
		});
		comboBox.setBounds(755, 50, 130, 37);
		add(comboBox);
		
		JLabel categoryLabel = new JLabel("Category");
		categoryLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		categoryLabel.setBounds(755, 27, 97, 16);
		add(categoryLabel);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchStudent();
			}
		});
		searchButton.setBounds(901, 50, 97, 37);
		add(searchButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 145, 905, 297);
		add(scrollPane);
		
	}
	
	private void searchStudent() {
		String[] columnNames = {"First Name",
                "Last Name",
                "BU-ID", 
                "Year", 
                "Degree",
                "Add to Course"};
		if(searchText.getText().equals("")) {
			JOptionPane.showMessageDialog(AddStudentToCourse.this, "Cannot be null!");	
		}
		else {
			StudentService sService = new StudentService();
			try {
				//TODO: after student has been added to the class, show "added" on another column. 
				//Implement this by search id in class DB
				switch(searchType) {
				case "BUid":
					students = sService.findStudentById(searchText.getText());
					break;
				case  "First Name":
					students = sService.findStudentByFirstName(searchText.getText());
					break;
				case "Last Name":
					students = sService.findStudentByLastName(searchText.getText());
					break;
				}
				int count = 0;
				if(!students.isEmpty()) {
					rst = new Object[students.size()][columnNames.length];
					for(Student s : students) {
						Object[] row = {s.getFirstName(),s.getLastName(), s.getStudentId(), s.getYear(), s.getType(),false};
						// Create a check method to see if student is already added to class
						rst[count] = row;
						count++;
					}
					
					DefaultTableModel tableModel=new DefaultTableModel(rst, columnNames){
						// This Method is to make a column not be Editable on Table.
					    @Override
					    public boolean isCellEditable(int row, int column) {
					        return column == rst[0].length-1 ? true: false; 
					    }
					    
					    // This Method Renders Checkbox on Table.
					    @Override
					    public Class<?> getColumnClass(int columnIndex) {
					        return getValueAt(0, columnIndex).getClass();
					    }
					};

					resultTable = new JTable(tableModel);
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
					scrollPane.setViewportView(resultTable);
					
					scrollPane.setViewportView(resultTable);
					}
				}catch(SQLException e) {}
			}
		}
}
