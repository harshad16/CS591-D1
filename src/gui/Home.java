package src.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import src.entities.Course;
import src.entities.User;
import src.service.CourseService;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;

public class Home extends JFrame {

	/**
	 * TODO: Write the doc.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private User user;
	private JLabel usernameText;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	CourseService courseService = new CourseService();
	private List<Course> courseList;
	
	
	private  List<Course> readCourses() {
		List<Course> courses = null;
				
	    try {
		    CourseService courseService = new CourseService();
		    courses  =   courseService.readCourses(null);
	    } catch (SQLException e) {
		    System.out.println(e);
	    }
	    return courses;
    }

	public Home() {
		initComponents();
	}
	
	public Home(User u) {
		this.user = u;
		initComponents();
	}
	
	public void initComponents() {
		setBounds(100, 100, 1280, 720);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		JLabel homeLabel = new JLabel();
		homeLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/home.png")));
		homeLabel.addMouseListener(new MouseListener () {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Home _home = new Home(user);
				_home.setVisible(true);
				setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		homeLabel.setBounds(90, 30, 50, 40);
		contentPane.add(homeLabel);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/user_32x32.png")));
		usernameLabel.setFont(new Font("Georgia", Font.BOLD, 14));
		usernameLabel.setBounds(1025, 50, 125, 30);
		contentPane.add(usernameLabel);
		
		usernameText = new JLabel();
		usernameText.setFont(new Font("Georgia", Font.PLAIN, 14));
		usernameText.setBounds(1150, 50, 100, 30);
		usernameText.setText(user.getUserName());
		contentPane.add(usernameText);
		
		JLabel returnLabel = new JLabel();
		returnLabel.setIcon(new ImageIcon(Home.class.getResource("/src/misc/back.png")));
		returnLabel.setBounds(30, 30, 50, 40);
		contentPane.add(returnLabel, BorderLayout.WEST);
		returnLabel.addMouseListener(new MouseListener () {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Index _index = new Index();
				_index.mainFrame.setVisible(true);
				setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		JButton addStudentButton = new JButton("Add Student in DB");
		addStudentButton.setIcon(new ImageIcon(Home.class.getResource("/src/misc/add_users.png")));
		addStudentButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		addStudentButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		addStudentButton.setHorizontalTextPosition(SwingConstants.CENTER);
		addStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GeneralFrame _addstudent = new GeneralFrame("Student", user);
				_addstudent.setVisible(true);
				setVisible(false);
			}
		});
		addStudentButton.setBounds(1027, 146, 163, 105);
		contentPane.add(addStudentButton);
		
		JLabel addCourseLabel = new JLabel("Add Course:");
		addCourseLabel.setBounds(12, 98, 121, 43);
		contentPane.add(addCourseLabel);
		addCourseLabel.setFont(new Font("Georgia", Font.PLAIN, 16));
		
		JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new GridLayout(0,4,30,30));
	    buttonPanel.setSize(new Dimension(400, 300)); 
	    
	    JScrollPane pane = new JScrollPane();
	    pane.setLocation(12,146);
	    pane.setSize(new Dimension(900, 514));
	    
	    JButton newCourseButton = new JButton();
		newCourseButton.setIcon(new ImageIcon(Home.class.getResource("/src/misc/add_course_.png")));
		newCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GeneralFrame _addcourse = new GeneralFrame("Course", user);
				_addcourse.setVisible(true);
				setVisible(false);
			}
		});
		buttonPanel.add(newCourseButton);

	    courseList = this.readCourses();
	    for (Course course: courseList) {
	    	if (course.getUserId() == user.getId()) {
		    	JButton btnCs = new JButton("<html>"+course.getName()+"<br>"
		    								+course.getCollege()+"<br>"
		    								+course.getCourseId()+"<br>"
		    								+course.getDays()+"<br>"
		    								+course.getStart_time()+"<br>"
		    								+"</html>");
				btnCs.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Dashboard _dashboard;
						try {
							_dashboard = new Dashboard(course,user);
							_dashboard.setVisible(true);
							setVisible(false);
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
				btnCs.setFont(new Font("Georgia", Font.PLAIN, 16));
				buttonPanel.add(btnCs);
	    	}
	    }
	    
	    pane.setViewportView(buttonPanel);
	    contentPane.add(pane);
	}
}
