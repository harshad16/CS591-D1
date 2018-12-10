package src.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JRadioButton rdbtnGraduate;
	private JRadioButton rdbtnUndergraduate;
	/**
	 * Create the panel.
	 */
	public AddStudentDB() {
		panel = new JPanel();
		setBounds(12, 146, 898, 527);
		setLayout(null);
		
		JLabel lblStudentFirstName = new JLabel("*First Name:");
		lblStudentFirstName.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblStudentFirstName.setBounds(309, 173, 500, 31);
		add(lblStudentFirstName);
		
		JLabel lblStudentLastName = new JLabel("*Last Name:");
		lblStudentLastName.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblStudentLastName.setBounds(309, 202, 500, 31);
		add(lblStudentLastName);
		
		JLabel lblNewLabel2 = new JLabel("*BU ID:");
		lblNewLabel2.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblNewLabel2.setBounds(309, 231, 500, 22);
		add(lblNewLabel2);
		
		JLabel lblCollege = new JLabel("*Year:");
		lblCollege.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblCollege.setBounds(309, 260, 500, 22);
		add(lblCollege);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Get focused");
				if(textField.getText() == null || textField.getText().equals("")) {
					lblStudentFirstName.setText("*First Name:(Cannot be null)");
					lblStudentFirstName.setForeground(Color.RED);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Focus lost");
				if(textField.getText() == null || textField.getText().equals("")) {
					lblStudentFirstName.setText("*First Name:(Cannot be null)");
					lblStudentFirstName.setForeground(Color.RED);
				}
				else {
					lblStudentFirstName.setText("*First Name:");
					lblStudentFirstName.setForeground(Color.BLACK);
				}
			}
			
		});
		textField.setBounds(810, 177, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Get focused");
				if(textField_1.getText() == null || textField_1.getText().equals("")) {
					System.out.println("text is null" );
					lblStudentLastName.setText("*Last Name:(Cannot be null)");
					lblStudentLastName.setForeground(Color.RED);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Focus lost");
				if(textField_1.getText() == null || textField_1.getText().equals("")) {
					System.out.println("text is null" );
					lblStudentLastName.setText("*Last Name:(Cannot be null)");
					lblStudentLastName.setForeground(Color.RED);
				}
				else {
					lblStudentLastName.setText("*Last Name:");
					lblStudentLastName.setForeground(Color.BLACK);
				}
			}
			
		});
		textField_1.setBounds(810, 206, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Get focused");
				if(textField_2.getText() == null || textField_2.getText().equals("")) {
					lblNewLabel2.setText("*BU ID:(Cannot be null)");
					lblNewLabel2.setForeground(Color.RED);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Focus lost");
				if(textField_2.getText() == null || textField_2.getText().equals("")) {
					lblNewLabel2.setText("*BU ID:(Cannot be null)");
					lblNewLabel2.setForeground(Color.RED);
				}
				else {
					lblNewLabel2.setText("*BU ID:");
					lblNewLabel2.setForeground(Color.BLACK);
				}
			}
			
		});
		textField_2.setBounds(810, 235, 116, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Get focused");
				if(textField_3.getText() == null || textField_3.getText().equals("")) {
					lblCollege.setText("*Year:(Cannot be null)");
					lblCollege.setForeground(Color.RED);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Focus lost");
				if(textField_3.getText() == null || textField_3.getText().equals("")) {
					lblCollege.setText("*Year:(Cannot be null)");
					lblCollege.setForeground(Color.RED);
				}
				else {
					lblCollege.setText("*Year:");
					lblCollege.setForeground(Color.BLACK);
				}
			}
			
		});;
		textField_3.setBounds(810, 264, 116, 22);
		add(textField_3);
		textField_3.setColumns(10);
		
		rdbtnGraduate = new JRadioButton("Graduate");
		rdbtnGraduate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnUndergraduate.setSelected(false);
			}
			
		});
		rdbtnGraduate.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnGraduate.setBounds(309, 293, 127, 25);
		add(rdbtnGraduate);
		
		rdbtnUndergraduate = new JRadioButton("UnderGraduate");
		rdbtnUndergraduate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rdbtnGraduate.setSelected(false);
			}
			
		});
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
					type = checkisSelected();
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
	
	private String checkisSelected() {
		if(rdbtnGraduate.isSelected()) {
			return "graduate";
			}
		else if(rdbtnUndergraduate.isSelected()) {
			return "underGraduate";
			}
		else {
			JOptionPane.showMessageDialog(panel, "Type cannot be null!");	
			return "";
		}
	}
	
	private boolean checkIsDup(Student s) {
		StudentService sService = new StudentService();
		List<Student> student;
		try {
			student = sService.findStudentByBUId(s.getStudentId());
			if(!student.isEmpty()) {
				//System.out.println(student.get(0));
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
