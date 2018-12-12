package src.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import src.entities.Assignment;
import src.entities.ClassEntity;
import src.entities.Grade;
import src.entities.Student;
import src.entities.User;
import src.service.AssignmentService;
import src.service.ClassService;
import src.service.GradeService;
import src.service.StudentService;
import src.entities.Course;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class Dashboard extends JFrame {
	
	/**
	 * TODO: Write the doc.
	 */
	private static final long serialVersionUID = 1L;
	//for transforming course object between frames
	private Course course;
	private JPanel contentPane;
	private JTable table;
	private JLabel usernameText;
	private DefaultTableModel tableModel;
	private JLabel courseNameText;
	private JLabel courseIdText;
	private JLabel courseYearText;
	private User user;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Dashboard() throws SQLException {
		initializeDashboard(true);			
	}
		
	public Dashboard(Course course,User u) throws SQLException {	
		//for keeping track of course information 
		this.course = course;
		this.user = u;
		initializeDashboard(true);
	}
	
	public void initializeDashboard(boolean def) throws SQLException {

		setBounds(100, 100, 1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/user_32x32.png")));
		usernameLabel.setFont(new Font("Georgia", Font.BOLD, 14));
		usernameLabel.setBounds(1025, 50, 125, 30);
		contentPane.add(usernameLabel);
		
		usernameText = new JLabel();
		usernameText.setText(user.getUserName());
		usernameText.setFont(new Font("Georgia", Font.PLAIN, 14));
		usernameText.setBounds(1150, 50, 100, 30);
		contentPane.add(usernameText);
		
		JLabel returnLabel = new JLabel();
		returnLabel.setIcon(new ImageIcon(Home.class.getResource("/src/misc/back.png")));
		returnLabel.setBounds(30, 30, 50, 40);
		contentPane.add(returnLabel, BorderLayout.WEST);
		returnLabel.addMouseListener(new MouseListener () {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Return to Home Page
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
		
		
		JLabel courseNameLabel = new JLabel("Course Name:");
		courseNameLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		courseNameLabel.setBounds(215, 22, 95, 22);
		contentPane.add(courseNameLabel);
		
		JLabel courseIdLabel = new JLabel("Course Id:");
		courseIdLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		courseIdLabel.setBounds(215, 51, 95, 25);
		contentPane.add(courseIdLabel);
		
		JLabel courseYearLabel = new JLabel("Year:");
		courseYearLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		courseYearLabel.setBounds(215, 80, 95, 26);
		contentPane.add(courseYearLabel);
		
		courseNameText = new JLabel();
		courseNameText.setText(course.getName());;
		courseNameText.setFont(new Font("Georgia", Font.PLAIN, 14));
		courseNameText.setBounds(322, 20, 263, 26);
		contentPane.add(courseNameText);
		
		courseIdText = new JLabel();
		courseIdText.setText(course.getCourseId());
		courseIdText.setFont(new Font("Georgia", Font.PLAIN, 14));
		courseIdText.setBounds(322, 52, 251, 26);
		contentPane.add(courseIdText);

		
		courseYearText = new JLabel();
		courseYearText.setText(course.getDays());
		courseYearText.setFont(new Font("Georgia", Font.PLAIN, 14));
		courseYearText.setBounds(322, 80, 251, 26);
		contentPane.add(courseYearText);
		
		JLabel homeLabel = new JLabel();
		homeLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/home.png")));
		homeLabel.addMouseListener(new MouseListener () {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Goto Home Page
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
		
		// TODO: Initially show the Dash board if no setup is selected.
		if(def) { 
			setDashboard("Dashboard");
		}
		
		JButton addAssignmentButton = new JButton("Add Assignment");
		addAssignmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					displayPanel("Assignment");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		addAssignmentButton.setBounds(30, 309, 133, 101);
		contentPane.add(addAssignmentButton);
		addAssignmentButton.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/add_course.png")));
		addAssignmentButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		addAssignmentButton.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JButton addStudentButton = new JButton("Add Students");
		addStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					displayPanel("Student");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		addStudentButton.setBounds(30, 423, 133, 101);
		contentPane.add(addStudentButton);
		addStudentButton.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/add_course.png")));
		addStudentButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		addStudentButton.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JButton viewStatsButton = new JButton("View Stats");
		viewStatsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					displayPanel("Stats");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		viewStatsButton.setBounds(30, 537, 133, 103);
		contentPane.add(viewStatsButton);
		viewStatsButton.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/view_stats.png")));
		viewStatsButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		viewStatsButton.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JButton dashboardButton = new JButton("Dashboard");
		dashboardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					displayPanel("Dashboard");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		dashboardButton.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/dashboard.png")));
		dashboardButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		dashboardButton.setHorizontalTextPosition(SwingConstants.CENTER);
		dashboardButton.setBounds(30, 200, 133, 96);
		contentPane.add(dashboardButton);
	}
	
	public void displayPanel(String panel_type) throws SQLException{
		initializeDashboard(false);
		if (panel_type.equals("Assignment")) {
			AddAssignments obj = new AddAssignments(course);
	        obj.setVisible(true);
	        contentPane.add(panel_type,obj);
	        ((JPanel) contentPane).revalidate();
	        contentPane.repaint();
		}
		else if (panel_type.equals("Student")) {
			AddStudentToCourse obj = new AddStudentToCourse(course);
	        obj.setVisible(true);
	        contentPane.add(panel_type,obj);
	        ((JPanel) contentPane).revalidate();
	        contentPane.repaint();
		}
		else if (panel_type.equals("Stats")) {
			Statistics obj = new Statistics();
	        obj.setVisible(true);
	        contentPane.add(panel_type,obj);
	        ((JPanel) contentPane).revalidate();
	        contentPane.repaint();
		}
		else {
			setDashboard("Dashboard");
		}
	}

	public void setDashboard(String panel_type) throws SQLException {
		JPanel panel = new JPanel();
		panel.setBounds(215, 146, 1021, 527);
		panel.setLayout(null);
		contentPane.add(panel_type,panel);
		((JPanel) contentPane).revalidate();
		contentPane.repaint();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 949, 459);
		scrollPane.setHorizontalScrollBarPolicy(
				   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
		
		// TODO get course id
		ClassService  clsService = new ClassService();
		StudentService sService = new StudentService();
		AssignmentService aService = new AssignmentService();
		GradeService gService = new GradeService();
		
		
		List<ClassEntity> classes = clsService.readClasses(course.getId());
		List<Student> students;
		List<Assignment> assignment;
		List<Grade> grade;
		
		
		// TODO: Built Column Name based upon assignment as well
		ArrayList<String> colNameList = new ArrayList<String>();
		String[] values = {"Sid(hidden)","First Name","Last Name","BU-ID","Degree"};
		for(String v:values) {
			colNameList.add(v);
		}
		assignment = aService.readAssignmentByCID(course.getId());
		for (Assignment asgnE: assignment) {
//			System.out.println("AssignmentAttributes:"+asgnE);
			colNameList.add(asgnE.getName());
		}
		colNameList.add("Grade");
		String[] columnNames = new String[colNameList.size()];
		columnNames = colNameList.toArray(columnNames);
		
		
		Object[][] data = new Object[classes.size()][columnNames.length];
		// Initialize with student info
		int rowCount=0;
		for (ClassEntity clsE: classes) {
        	students = sService.findStudentById(clsE.getStudentId());
        	Object[] row = new Object[columnNames.length];
        	for(Student std : students) {
        		System.out.println("Student:"+std);
        		row[0]=std.getId();
				row[1]=std.getFirstName();
				row[2]=std.getLastName();
				row[3]=std.getStudentId(); 
				row[4]=std.getType();
				
				grade = gService.readGradesByStudentId((Integer)std.getId());
				for(Grade grd:grade) {
//					System.out.println("GradeAttributes:"+grd);
//					System.out.println(columnNames[5]);
					for(int j=5;j<columnNames.length-1;j++) {
						if(columnNames[j].equals(grd.getAssignment().getName())) {
							row[j]=grd.getGrade();
							break;
						}
					}
				}
    			// Create a check method to see if student is already added to class
    			data[rowCount] = row;
    			rowCount++;
    		}
		}
		
		
		// TODO: GET VALUES from Grades
		for(int i=0;i<rowCount;i++) {
			for(int j=5;j<columnNames.length;j++) {
				if (j == columnNames.length-1) {
					data[i][j]="";
				}
				else if (data[i][j]==null) {
					data[i][j]=new Integer(0);	
				}
			}
		}
		
		// TODO: calculate GRADES
		
		
		tableModel=new DefaultTableModel(data, columnNames){
			private static final long serialVersionUID = 1L;
			
			// This Method is to make a column not be Editable on Table.
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return column == data[0].length-1 || column <= 4 ? false: true; 
		    }
		    
		    // This Method Renders Checkbox on Table.
		    @Override
		    public Class<?> getColumnClass(int columnIndex) {
		        return getValueAt(0, columnIndex).getClass();
		    }
		};
		
		
		table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(400, 400));
		table.getTableHeader().setForeground(SystemColor.textHighlight);
		table.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 16));
		table.getTableHeader().setReorderingAllowed(false);
		Dimension d = table.getTableHeader().getPreferredSize();
		d.height = 30;
		table.getTableHeader().setSize(d);
		table.setFillsViewportHeight(true);
		table.setRowHeight(30);
		table.setFont(new Font("Georgia", Font.PLAIN, 16));
		// Hide the id column
		table.removeColumn(table.getColumnModel().getColumn(0));
		scrollPane.setViewportView(table);
		
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Integer assignmentId = null;
				Integer sid;
				Double grade = null;
				GradeService gService = new GradeService();
//				System.out.println("Dashboard Elements: ");
				for (int row = 0; row < table.getRowCount(); row++){
					sid = (Integer) tableModel.getValueAt(row, 0);
					for (int col = 4; col < table.getColumnCount()-1; col++){
//						System.out.print(table.getValueAt(row, col)+" ");
						// Fields Integer assignmentId, Integer studentId, String note, Double grade
						for (Assignment asgnE: assignment) {
//							System.out.println("AssignmentAttributes:"+table.getColumnName(col));
//							System.out.println("AssignmentName:"+asgnE.getName());
							if (asgnE.getName().equals(table.getColumnName(col))) {
								assignmentId = asgnE.getAssignmentId();
//								System.out.println("AssignmentId:"+asgnE.getAssignmentId());
								grade = ((Number) table.getValueAt(row, col)).doubleValue();
								break;
							}
						}
						// Saving the Grades.
						Grade stdGrade = new Grade(assignmentId,sid,"",grade);
						try {
							gService.saveGrade(stdGrade);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				JOptionPane.showMessageDialog(Dashboard.this, "Successfully Saved Scores!");
			}
		});
		saveButton.setBounds(755, 485, 97, 25);
		panel.add(saveButton);
		
		
		JButton clearButton = new JButton("Clear");
		// TODO: Need to Come up with better logic
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
			}
		});
		clearButton.setBounds(864, 485, 97, 25);
		panel.add(clearButton);
		
		JLabel gradeButton = new JLabel();
		gradeButton.setIcon(new ImageIcon(AddAssignments.class.getResource("/src/misc/logo_32x32.png")));
		// WIP: working on better logic
		gradeButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Double score = 0.0;
				Double grade = null;
				GradeService gService = new GradeService();
//				System.out.println("Dashboard Elements: ");
				for (int row = 0; row < table.getRowCount(); row++){
					for (int col = 4; col < table.getColumnCount()-1; col++){
//						System.out.print(table.getValueAt(row, col)+" ");
						// Fields Integer assignmentId, Integer studentId, String note, Double grade
						for (Assignment asgnE: assignment) {
//							System.out.println("AssignmentAttributes:"+table.getColumnName(col));
//							System.out.println("AssignmentName:"+asgnE.getName());
							if (asgnE.getName().equals(table.getColumnName(col))) {
								score += (asgnE.getWeight()*((Number) table.getValueAt(row, col)).doubleValue())/100;
							}
						}
					}
				}
				JOptionPane.showMessageDialog(Dashboard.this, "Successfully Saved Scores!");
			
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
		gradeButton.setBounds(696, 476, 32, 38);
		panel.add(gradeButton);

	}

}
