package src.gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddStudentDB extends JPanel {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Create the panel.
	 */
	public AddStudentDB() {
		JPanel panel = new JPanel();
		setBounds(12, 146, 898, 527);
		setLayout(null);
		
		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblStudentName.setBounds(309, 173, 127, 31);
		add(lblStudentName);
		
		JLabel lblNewLabel2 = new JLabel("BU ID:");
		lblNewLabel2.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblNewLabel2.setBounds(309, 202, 127, 22);
		add(lblNewLabel2);
		
		JLabel lblCollege = new JLabel("College:");
		lblCollege.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblCollege.setBounds(309, 231, 127, 22);
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
		
		JRadioButton rdbtnGraduate = new JRadioButton("Graduate");
		rdbtnGraduate.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnGraduate.setBounds(309, 277, 127, 25);
		add(rdbtnGraduate);
		
		JRadioButton rdbtnUndergraduate = new JRadioButton("UnderGraduate");
		rdbtnUndergraduate.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnUndergraduate.setBounds(445, 271, 146, 37);
		add(rdbtnUndergraduate);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		btnNewButton.setBounds(373, 357, 88, 37);
		add(btnNewButton);
	}

}
