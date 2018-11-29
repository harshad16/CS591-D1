package src.gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCourse extends JPanel {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public AddCourse() {
		
		setBounds(12, 146, 898, 527);
		setLayout(null);
		
		JLabel lblStudentName = new JLabel("Course Name:");
		lblStudentName.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblStudentName.setBounds(122, 97, 127, 31);
		add(lblStudentName);
		
		JLabel lblNewLabel2 = new JLabel("Course ID:");
		lblNewLabel2.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblNewLabel2.setBounds(122, 126, 127, 22);
		add(lblNewLabel2);
		
		JLabel lblCollege = new JLabel("College:");
		lblCollege.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblCollege.setBounds(122, 155, 127, 22);
		add(lblCollege);
		
		textField = new JTextField();
		textField.setBounds(288, 101, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(288, 130, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(288, 159, 116, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		JRadioButton rdbtnGraduate = new JRadioButton("Graduate");
		rdbtnGraduate.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnGraduate.setBounds(288, 209, 127, 25);
		add(rdbtnGraduate);
		
		JRadioButton rdbtnUndergraduate = new JRadioButton("UnderGraduate");
		rdbtnUndergraduate.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnUndergraduate.setBounds(288, 232, 146, 31);
		add(rdbtnUndergraduate);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		btnNewButton.setBounds(212, 323, 88, 37);
		add(btnNewButton);
		
		JRadioButton rdbtnBoth = new JRadioButton("Both");
		rdbtnBoth.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnBoth.setBounds(288, 253, 146, 37);
		add(rdbtnBoth);
		
		JLabel lblCourseLevel = new JLabel("Course Level:");
		lblCourseLevel.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblCourseLevel.setBounds(122, 209, 127, 22);
		add(lblCourseLevel);

	}
}
