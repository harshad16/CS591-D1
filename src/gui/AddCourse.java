package src.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import src.entities.Assignment;
import src.entities.Course;
import src.entities.User;
import src.service.AssignmentService;
import src.service.CourseService;

public class AddCourse extends JPanel {
		
	/**
	 * Class for adding course to the Database
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameTF;
	private JTextField courseIdTF;
	private JTextField collegeTF;
	private JTextField descriptionTF;
	private JTextField startTimeTF;
	private JTextField daysTF;
	private User user;
	private JTextField yearTF;

	public AddCourse(User u) {
		
		this.user = u;
		JPanel panel = new JPanel();				
		setBounds(12, 146, 898, 527);
		setLayout(null);
		
		JLabel courseNameLabel = new JLabel("Course Name:");
		courseNameLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		courseNameLabel.setBounds(122, 93, 127, 31);
		add(courseNameLabel);
		
		JLabel courseIdLabel = new JLabel("Course ID:");
		courseIdLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		courseIdLabel.setBounds(122, 126, 127, 22);
		add(courseIdLabel);
		
		JLabel collegeLabel = new JLabel("College:");
		collegeLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		collegeLabel.setBounds(122, 158, 127, 22);
		add(collegeLabel);
		
		JLabel descriptionLabel = new JLabel("Description:");
		descriptionLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		descriptionLabel.setBounds(532, 97, 127, 22);
		add(descriptionLabel);
		
		JLabel startTimeLabel = new JLabel("Start Time:");
		startTimeLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		startTimeLabel.setBounds(532, 126, 127, 22);
		add(startTimeLabel);
		
		JLabel daysLabel = new JLabel("Days:");
		daysLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		daysLabel.setBounds(532, 155, 127, 22);
		add(daysLabel);
		
		JLabel yearLabel = new JLabel("Year:");
		yearLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		yearLabel.setBounds(122, 190, 127, 22);
		add(yearLabel);
		
		JLabel courseLevelLabel = new JLabel("Course Level:");
		courseLevelLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		courseLevelLabel.setBounds(122, 232, 127, 22);
		add(courseLevelLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(288, 98, 116, 22);
		add(nameTF);
		nameTF.setColumns(10);
		
		courseIdTF = new JTextField();
		courseIdTF.setBounds(288, 127, 116, 22);
		add(courseIdTF);
		courseIdTF.setColumns(10);
		
		collegeTF = new JTextField();
		collegeTF.setBounds(288, 159, 116, 22);
		add(collegeTF);
		collegeTF.setColumns(10);
		
		descriptionTF = new JTextField();
		descriptionTF.setBounds(698, 98, 116, 22);
		add(descriptionTF);
		descriptionTF.setColumns(10);
		
		startTimeTF = new JTextField();
		startTimeTF.setBounds(698, 127, 116, 22);
		add(startTimeTF);
		startTimeTF.setColumns(10);
		
		daysTF = new JTextField();
		daysTF.setBounds(698, 156, 116, 22);
		add(daysTF);
		daysTF.setColumns(10);
		
		yearTF = new JTextField();
		yearTF.setColumns(10);
		yearTF.setBounds(288, 191, 116, 22);
		add(yearTF);
		
		ButtonGroup group = new ButtonGroup();
		
		
		JRadioButton rdbtnGraduate = new JRadioButton("Graduate");
		rdbtnGraduate.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnGraduate.setBounds(288, 220, 127, 25);
		add(rdbtnGraduate);
		group.add(rdbtnGraduate);
		
		JRadioButton rdbtnUndergraduate = new JRadioButton("UnderGraduate");
		rdbtnUndergraduate.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnUndergraduate.setBounds(288, 243, 146, 31);
		add(rdbtnUndergraduate);
		group.add(rdbtnUndergraduate);
		
		JRadioButton rdbtnBoth = new JRadioButton("Both");
		rdbtnBoth.setFont(new Font("Georgia", Font.PLAIN, 16));
		rdbtnBoth.setBounds(288, 264, 146, 37);
		add(rdbtnBoth);
		group.add(rdbtnBoth);
		
		JRadioButton importAssignmentrdBtn = new JRadioButton("Import assignments of most recent course");
		importAssignmentrdBtn.setFont(new Font("Georgia", Font.PLAIN, 16));
		importAssignmentrdBtn.setBounds(532, 203, 700, 37);
		add(importAssignmentrdBtn);
		
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 16));
		btnNewButton.setBounds(212, 323, 88, 37);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
 			@Override
			public void actionPerformed(ActionEvent e) {
					String name = nameTF.getText();
					String description = descriptionTF.getText();
					String startTime = startTimeTF.getText();
					String days = daysTF.getText();
					String college = collegeTF.getText();
					String courseId = courseIdTF.getText();
					String yearId = yearTF.getText();
					String type = "";
					Integer userid = user.getId();
					if(rdbtnGraduate.isSelected()) {
						type = "graduate";
					}
					
					if(rdbtnUndergraduate.isSelected()) {
						type = "underGraduate";
					}
					
					Course c = new Course(name, description, startTime, days, courseId, college, type, userid, yearId);
					Course mrCourse = getMostRecentCourse();
					if(mrCourse!=null) {
						c.setAssignments(mrCourse.getAssignments());
						Integer rst = saveCourse(c);
						Boolean assignmentSaved = true;
						if(rst != -1) {
							if (importAssignmentrdBtn.isSelected()) {
							    for (Assignment a: c.getAssignments()) {
								    a.setCourseId(rst);
								    a.setAssignmentId(null);
								    assignmentSaved = saveAssignment(a);
								    if (!assignmentSaved ) break;
							    }
							}    
							if (assignmentSaved)
						        JOptionPane.showMessageDialog(panel, "Success!");	
						}else if (rst == -1){
								JOptionPane.showMessageDialog(panel, "Error!");	
						}
					} else {
						saveCourse(c);
					}
 			 }
		});
	}

    private Integer saveCourse(Course c) {
    	Integer id = null;
	    try {
		    CourseService courseService = new CourseService();
		    id = courseService.saveCourseId(c);
	    } catch (SQLException e) {
		    return -1;
	    }
	    return id;
    }
    
    private Course getMostRecentCourse() {
    	List<Course> courseList = null;
    	Course mostRecentCourse = null;
    	try {
		    CourseService courseService = new CourseService();
		    courseList = courseService.readMostRecentCourse();
		    if(!courseList.isEmpty()) {
		    	mostRecentCourse = courseList.get(0);
		    }
	    } catch (SQLException e) {
		    return null;
	    }
    	return mostRecentCourse;
    }
    
    private Boolean saveAssignment(Assignment a) {
    	 try {
 	    	AssignmentService assignmentService = new AssignmentService();
 	    	assignmentService.saveAssignment(a);
 	    } catch (SQLException e) {
 		    return false;
 	    }
 	    return true;	
    }
}
