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
	 * Class for adding Students into Database. 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField firstNameTF;
	private JTextField lastNameTF;
	private JTextField buIDTF;
	private JTextField clgYearTF;
	private JRadioButton rdbtnGraduate;
	private JRadioButton rdbtnUndergraduate;
	private JLabel lblDegree;

	public AddStudentDB() {
		panel = new JPanel();
		setBounds(12, 146, 898, 527);
		setLayout(null);

		JLabel firstNameLabel = new JLabel("*First Name:");
		firstNameLabel.setFont(new Font("Georgia", Font.PLAIN, 16));
		firstNameLabel.setBounds(115, 170, 201, 30);
		add(firstNameLabel);

		JLabel lastNameLabel = new JLabel("*Last Name:");
		lastNameLabel.setFont(new Font("Georgia", Font.PLAIN, 16));
		lastNameLabel.setBounds(115, 205, 201, 30);
		add(lastNameLabel);

		JLabel buIdLabel = new JLabel("*BU ID:");
		buIdLabel.setFont(new Font("Georgia", Font.PLAIN, 16));
		buIdLabel.setBounds(115, 240, 201, 30);
		add(buIdLabel);

		JLabel clgYearLabel = new JLabel("*Year:");
		clgYearLabel.setFont(new Font("Georgia", Font.PLAIN, 16));
		clgYearLabel.setBounds(115, 275, 201, 30);
		add(clgYearLabel);

		lblDegree = new JLabel("Degree");
		lblDegree.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblDegree.setBounds(115, 311, 115, 30);
		add(lblDegree);
		
		firstNameTF = new JTextField();
		firstNameTF.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(firstNameTF.getText() == null || firstNameTF.getText().equals("")) {
					firstNameLabel.setText("*First Name:(Cannot be null)");
					firstNameLabel.setForeground(Color.RED);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(firstNameTF.getText() == null || firstNameTF.getText().equals("")) {
					firstNameLabel.setText("*First Name:(Cannot be null)");
					firstNameLabel.setForeground(Color.RED);
				}
				else {
					firstNameLabel.setText("*First Name:");
					firstNameLabel.setForeground(Color.BLACK);
				}
			}
		});
		firstNameTF.setBounds(340, 171, 115, 30);
		add(firstNameTF);
		firstNameTF.setColumns(10);

		lastNameTF = new JTextField();
		lastNameTF.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(lastNameTF.getText() == null || lastNameTF.getText().equals("")) {
					lastNameLabel.setText("*Last Name:(Cannot be null)");
					lastNameLabel.setForeground(Color.RED);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(lastNameTF.getText() == null || lastNameTF.getText().equals("")) {
					lastNameLabel.setText("*Last Name:(Cannot be null)");
					lastNameLabel.setForeground(Color.RED);
				}
				else {
					lastNameLabel.setText("*Last Name:");
					lastNameLabel.setForeground(Color.BLACK);
				}
			}
		});
		lastNameTF.setBounds(340, 206, 115, 30);
		add(lastNameTF);
		lastNameTF.setColumns(10);
		
		buIDTF = new JTextField();
		buIDTF.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(buIDTF.getText() == null || buIDTF.getText().equals("")) {
					buIdLabel.setText("*BU ID:(Cannot be null)");
					buIdLabel.setForeground(Color.RED);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(buIDTF.getText() == null || buIDTF.getText().equals("")) {
					buIdLabel.setText("*BU ID:(Cannot be null)");
					buIdLabel.setForeground(Color.RED);
				}
				else {
					buIdLabel.setText("*BU ID:");
					buIdLabel.setForeground(Color.BLACK);
				}
			}
		});
		buIDTF.setBounds(340, 241, 115, 30);
		add(buIDTF);
		buIDTF.setColumns(10);

		clgYearTF = new JTextField();
		clgYearTF.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(clgYearTF.getText() == null || clgYearTF.getText().equals("")) {
					clgYearLabel.setText("*Year:(Cannot be null)");
					clgYearLabel.setForeground(Color.RED);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(clgYearTF.getText() == null || clgYearTF.getText().equals("")) {
					clgYearLabel.setText("*Year:(Cannot be null)");
					clgYearLabel.setForeground(Color.RED);
				}
				else {
					clgYearLabel.setText("*Year:");
					clgYearLabel.setForeground(Color.BLACK);
				}
			}
			
		});;
		clgYearTF.setBounds(340, 276, 115, 30);
		add(clgYearTF);
		clgYearTF.setColumns(10);

		rdbtnGraduate = new JRadioButton("Graduate");
		rdbtnGraduate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnUndergraduate.setSelected(false);
			}
		});
		rdbtnGraduate.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnGraduate.setBounds(115, 340, 125, 30);
		add(rdbtnGraduate);

		rdbtnUndergraduate = new JRadioButton("UnderGraduate");
		rdbtnUndergraduate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnGraduate.setSelected(false);
			}
		});
		rdbtnUndergraduate.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnUndergraduate.setBounds(244, 340, 150, 30);
		add(rdbtnUndergraduate);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					String FirstName = firstNameTF.getText();
					String LastName = lastNameTF.getText();
					String buId = buIDTF.getText();
					String year = clgYearTF.getText();
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
		btnNewButton.setBounds(300, 403, 88, 37);
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
				return true;
			}
			else return false;
		} catch (SQLException e) {
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
