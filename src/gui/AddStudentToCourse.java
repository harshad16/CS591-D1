package src.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import src.entities.Student;
import src.service.ClassService;
import src.service.StudentService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AddStudentToCourse extends JPanel {
	private JTextField textField;
	private String searchType;
	private List<Student> students;
	private Object[][] rst;
	private JScrollPane scrollPane;
	private Student selectedStudent;

	/**
	 * Create the panel.
	 */
	public AddStudentToCourse() {
		setBounds(215, 146, 1021, 527);
		setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// save student from selected table row
				
			}
		});
		btnNewButton_2.setBounds(755, 485, 97, 25);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_3.setBounds(864, 485, 97, 25);
		add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(214, 50, 518, 37);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewAbel = new JLabel("Search :");
		lblNewAbel.setIcon(new ImageIcon(AddStudentToCourse.class.getResource("/src/misc/search_32x32.png")));
		lblNewAbel.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblNewAbel.setBounds(93, 49, 109, 37);
		add(lblNewAbel);
		
		String[] category = {"BUid", "First Name", "Last Name"};
		JComboBox<String> comboBox = new JComboBox<>(category);
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
		
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblNewLabel.setBounds(755, 27, 97, 16);
		add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchStudent();
			}
		});
		
		
		btnNewButton.setBounds(901, 50, 97, 37);
		add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 145, 905, 100);
		add(scrollPane);
		

	}
	
	private void searchStudent() {
		String[] columnNames = {"First Name",
                "Last Name",
                "BU-ID", 
                "Year", 
                "Type"};
		if(textField.getText().equals("")) {
			JOptionPane.showMessageDialog(AddStudentToCourse.this, "Cannot be null!");	
		}
		else {
			StudentService sService = new StudentService();
			try {
				//TODO: after student has been added to the class, show "added" on another column. 
				//Implement this by search id in class DB
				switch(searchType) {
				case "BUid":
					students = sService.findStudentById(textField.getText());
					break;
				case  "First Name":
					students = sService.findStudentByFirstName(textField.getText());
					break;
				case "Last Name":
					students = sService.findStudentByLastName(textField.getText());
					break;
				}
				int count = 0;
				if(!students.isEmpty()) {
					rst = new String[students.size()][columnNames.length];
					for(Student s : students) {
						String[] row = {s.getFirstName(),s.getLastName(), s.getStudentId(), s.getYear(), s.getType()};
						rst[count] = row;
						count++;
					}
					JTable resultTable = new JTable(rst, columnNames);
					resultTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

						@Override
						public void valueChanged(ListSelectionEvent e) {
							 if (resultTable.getSelectedRow() > -1) {
								 int row = resultTable.getSelectedRow();
								 Student s = new Student((String)resultTable.getValueAt(row, 2),
										 (String)resultTable.getValueAt(row, 0), 
										 (String)resultTable.getValueAt(row, 1),
										 (String)resultTable.getValueAt(row, 3),
										 (String)resultTable.getValueAt(row, 4));
								 selectedStudent = s;
								 System.out.println(selectedStudent);
							 }	
						}
						
					});
					
					scrollPane.setViewportView(resultTable);
				}
			}catch(SQLException e) {
				
			}
		}
		
	}
}
