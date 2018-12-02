package src.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import src.entities.Student;
import src.service.StudentService;

public class AddStudentDB extends JPanel {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Create the panel.
	 */
	public AddStudentDB() {
		JPanel panel = new JPanel();
		setBounds(12, 146, 898, 527);
		setLayout(null);
		
		JLabel lblStudentFirstName = new JLabel("First Name:");
		lblStudentFirstName.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblStudentFirstName.setBounds(309, 173, 127, 31);
		add(lblStudentFirstName);
		
		JLabel lblStudentLastName = new JLabel("Last Name:");
		lblStudentLastName.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblStudentLastName.setBounds(309, 202, 127, 31);
		add(lblStudentLastName);
		
		JLabel lblNewLabel2 = new JLabel("BU ID:");
		lblNewLabel2.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblNewLabel2.setBounds(309, 231, 127, 22);
		add(lblNewLabel2);
		
		JLabel lblCollege = new JLabel("Year:");
		lblCollege.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblCollege.setBounds(309, 260, 127, 22);
		add(lblCollege);
		
		textField = new JTextField();
		textField.setBounds(475, 177, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(475, 206, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(475, 235, 116, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(475, 264, 116, 22);
		add(textField_3);
		textField_3.setColumns(10);
		
		JRadioButton rdbtnGraduate = new JRadioButton("Graduate");
		rdbtnGraduate.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnGraduate.setBounds(309, 293, 127, 25);
		add(rdbtnGraduate);
		
		JRadioButton rdbtnUndergraduate = new JRadioButton("UnderGraduate");
		rdbtnUndergraduate.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnUndergraduate.setBounds(445, 293, 146, 37);
		add(rdbtnUndergraduate);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					String FirstName = textField.getText();
					String LastName = textField_1.getText();
					String buId = textField_2.getText();
					String year = textField_3.getText();
					String type = "";
					if(rdbtnGraduate.isSelected()) {
						type = "graduate";
						}
					if(rdbtnUndergraduate.isSelected()) {
						type = "underGraduate";
						}
					Student s = new Student(buId,FirstName, LastName, year, type);
					boolean isDup = checkIsDup(s);
					if(isDup) {
						JOptionPane.showMessageDialog(panel, "Student alreday exists!");	
					}
					else {
						boolean rst = saveStudent(s);
						if(rst) {
							JOptionPane.showMessageDialog(panel, "Success!");	
						}else {
							JOptionPane.showMessageDialog(panel, "Error!");	
						}		
					}
					
			}
			
		});
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		btnNewButton.setBounds(373, 357, 88, 37);
		add(btnNewButton);
	}
	
	private boolean checkIsDup(Student s) {
		StudentService sService = new StudentService();
		List<Student> student;
		try {
			student = sService.findStudentById(s.getStudentId());
			if(!student.isEmpty()) {
				return true;
			}
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean saveStudent(Student s) {
		try {
			StudentService sService = new StudentService();
			sService.saveStudent(s);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

}
