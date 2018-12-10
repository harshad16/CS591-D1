package src.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import src.entities.Course;
import src.service.CourseService;

public class AddCourse extends JPanel {
		
	private JTextField nameTF;
	private JTextField courseIdTF;
	private JTextField collegeTF;
	private JTextField descriptionTF;
	private JTextField startTimeTF;
	private JTextField daysTF;

	/**
	 * Create the panel.
	 */
	public AddCourse() {
		
		JPanel panel = new JPanel();				
		setBounds(12, 146, 898, 527);
		setLayout(null);
		
		JLabel lblCourseName = new JLabel("Course Name:");
		lblCourseName.setFont(new Font("Georgia", Font.BOLD, 16));
		lblCourseName.setBounds(122, 97, 127, 31);
		add(lblCourseName);
		
		JLabel lblCourseId = new JLabel("Course ID:");
		lblCourseId.setFont(new Font("Georgia", Font.BOLD, 16));
		lblCourseId.setBounds(122, 126, 127, 22);
		add(lblCourseId);
		
		JLabel lblCollege = new JLabel("College:");
		lblCollege.setFont(new Font("Georgia", Font.BOLD, 16));
		lblCollege.setBounds(122, 155, 127, 22);
		add(lblCollege);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Georgia", Font.BOLD, 16));
		lblDescription.setBounds(600, 97, 127, 22);
		add(lblDescription);
		
		JLabel lblStartTime = new JLabel("Start Time:");
		lblStartTime.setFont(new Font("Georgia", Font.BOLD, 16));
		lblStartTime.setBounds(600, 126, 127, 22);
		add(lblStartTime);
		
		JLabel lblDays = new JLabel("Days:");
		lblDays.setFont(new Font("Georgia", Font.BOLD, 16));
		lblDays.setBounds(600, 155, 127, 22);
		add(lblDays);
		
		nameTF = new JTextField();
		nameTF.setBounds(288, 101, 116, 22);
		add(nameTF);
		nameTF.setColumns(10);
		
		courseIdTF = new JTextField();
		courseIdTF.setBounds(288, 130, 116, 22);
		add(courseIdTF);
		courseIdTF.setColumns(10);
		
		collegeTF = new JTextField();
		collegeTF.setBounds(288, 159, 116, 22);
		add(collegeTF);
		collegeTF.setColumns(10);
		
		descriptionTF = new JTextField();
		descriptionTF.setBounds(766, 101, 116, 22);
		add(descriptionTF);
		descriptionTF.setColumns(10);
		
		startTimeTF = new JTextField();
		startTimeTF.setBounds(766, 130, 116, 22);
		add(startTimeTF);
		startTimeTF.setColumns(10);
		
		daysTF = new JTextField();
		daysTF.setBounds(766, 159, 116, 22);
		add(daysTF);
		daysTF.setColumns(10);
		
		JRadioButton rdbtnGraduate = new JRadioButton("Graduate");
		rdbtnGraduate.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnGraduate.setBounds(288, 209, 127, 25);
		add(rdbtnGraduate);
		
		JRadioButton rdbtnUndergraduate = new JRadioButton("UnderGraduate");
		rdbtnUndergraduate.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnUndergraduate.setBounds(288, 232, 146, 31);
		add(rdbtnUndergraduate);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 16));
		btnNewButton.setBounds(212, 323, 88, 37);
		add(btnNewButton);
		
		JRadioButton rdbtnBoth = new JRadioButton("Both");
		rdbtnBoth.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnBoth.setBounds(288, 253, 146, 37);
		add(rdbtnBoth);
		
		JLabel lblCourseLevel = new JLabel("Course Level:");
		lblCourseLevel.setFont(new Font("Georgia", Font.BOLD, 16));
		lblCourseLevel.setBounds(122, 209, 127, 22);
		add(lblCourseLevel);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
 			@Override
			public void actionPerformed(ActionEvent e) {
					String name = nameTF.getText();
					String description = descriptionTF.getText();
					String startTime = startTimeTF.getText();
					String days = daysTF.getText();
					String college = collegeTF.getText();
					String courseId = courseIdTF.getText();
					String type = "";
					if(rdbtnGraduate.isSelected()) {
						type = "graduate";
					}
					
					if(rdbtnUndergraduate.isSelected()) {
						type = "underGraduate";
					}
					
					Course c = new Course(name, description, startTime, days, courseId, college, type);
					boolean rst = saveCourse(c);
					if(rst) {
					    JOptionPane.showMessageDialog(panel, "Success!");	
					}else {
							JOptionPane.showMessageDialog(panel, "Error!");	
					}		
 			 }
		});
	}

    private boolean saveCourse(Course c) {
	    try {
		    CourseService courseService = new CourseService();
		    courseService.saveCourse(c);
	    } catch (SQLException e) {
		    return false;
	    }
	    return true;
    }
}
