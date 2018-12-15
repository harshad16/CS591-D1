package src.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.opencsv.CSVWriter;
import src.entities.Assignment;
import src.entities.CalculateGrade;
import src.entities.CapitalizeUtil;
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
	private Course course;
	private JPanel contentPane;
	private JTable table;
	private JLabel usernameText;
	private DefaultTableModel tableModel;
	private JLabel courseNameText;
	private JLabel courseIdText;
	private JLabel courseYearText;
	private User user;
	private String[] columnNames;

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
		usernameText.setText(CapitalizeUtil.captilize(user.getUserName()));
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
		courseNameLabel.setBounds(215, 20, 95, 25);
		contentPane.add(courseNameLabel);
		
		JLabel courseIdLabel = new JLabel("Course Id:");
		courseIdLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		courseIdLabel.setBounds(215, 50, 95, 25);
		contentPane.add(courseIdLabel);
		
		JLabel typeLabel = new JLabel("Degree type:");
		typeLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		typeLabel.setBounds(215, 80, 95, 25);
		contentPane.add(typeLabel);
		
		JLabel collegeLabel = new JLabel("College:");
		collegeLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		collegeLabel.setBounds(500, 20, 65, 25);
		contentPane.add(collegeLabel);

		JLabel courseYearLabel = new JLabel("Year:");
		courseYearLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		courseYearLabel.setBounds(500, 50, 65, 25);
		contentPane.add(courseYearLabel);

		JLabel daysLabel = new JLabel("Days:");
		daysLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		daysLabel.setBounds(500, 80, 65, 25);
		contentPane.add(daysLabel);
		
		
		courseNameText = new JLabel();
		courseNameText.setText(CapitalizeUtil.captilize(course.getName()));;
		courseNameText.setFont(new Font("Georgia", Font.PLAIN, 14));
		courseNameText.setBounds(320, 20, 165, 25);
		contentPane.add(courseNameText);

		courseIdText = new JLabel();
		courseIdText.setText(CapitalizeUtil.captilize(course.getCourseId()));
		courseIdText.setFont(new Font("Georgia", Font.PLAIN, 14));
		courseIdText.setBounds(320, 50, 165, 25);
		contentPane.add(courseIdText);

		JLabel TypeText = new JLabel();
		TypeText.setText(CapitalizeUtil.captilize(course.getType()));
		TypeText.setFont(new Font("Georgia", Font.PLAIN, 14));
		TypeText.setBounds(320, 80, 165, 25);
		contentPane.add(TypeText);
		
		JLabel collegeText = new JLabel();
		collegeText.setText(CapitalizeUtil.captilize(course.getCollege()));
		collegeText.setFont(new Font("Georgia", Font.PLAIN, 14));
		collegeText.setBounds(570, 20, 165, 25);
		contentPane.add(collegeText);

		courseYearText = new JLabel();
		courseYearText.setText(CapitalizeUtil.captilize(course.getYear()));
		courseYearText.setFont(new Font("Georgia", Font.PLAIN, 14));
		courseYearText.setBounds(570, 50, 165, 25);
		contentPane.add(courseYearText);

		
		JLabel daysText = new JLabel();
		daysText.setText(CapitalizeUtil.captilize(course.getDays()));
		daysText.setFont(new Font("Georgia", Font.PLAIN, 14));
		daysText.setBounds(570, 80, 165, 25);
		contentPane.add( daysText);
		
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
		
		// TODO: Initially show the Dash board with all students if no setup is selected.
		if(def) { 
			setDashboard("Dashboard");
		}
		
		JButton addAssignmentButton = new JButton("Add Assignment");
		addAssignmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					displayPanel("Assignment");
				} catch (SQLException e1) {
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
			AddStudentToCourse obj = new AddStudentToCourse(course,user);
	        obj.setVisible(true);
	        contentPane.add(panel_type,obj);
	        ((JPanel) contentPane).revalidate();
	        contentPane.repaint();
		}
		else if (panel_type.equals("Stats")) {
			Statistics obj = new Statistics(course);
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
		scrollPane.setBounds(12, 70, 950, 400);
		scrollPane.setHorizontalScrollBarPolicy(
				   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
		// Services
		ClassService  clsService = new ClassService();
		StudentService sService = new StudentService();
		AssignmentService aService = new AssignmentService();
		GradeService gService = new GradeService();
		
		// Lists
		List<ClassEntity> classes = clsService.readClasses(course.getId());
		List<Student> students;
		List<Assignment> assignment;
		List<Grade> grade = null;
		
		// Built Column Name based upon assignment as well
			ArrayList<String> colNameList = new ArrayList<String>();
			String[] values = {"Sid(hidden)","First Name","Last Name","BU-ID","Degree"};
			for(String v:values) {
				colNameList.add(v);
			}
			assignment = aService.readAssignmentByCID(course.getId());
			for (Assignment asgnE: assignment) {
				colNameList.add(asgnE.getName()+"("+asgnE.getTotal()+")");
			}
			colNameList.add("Total Score");
			colNameList.add("Estimate Grade");
			columnNames = new String[colNameList.size()];
			columnNames = colNameList.toArray(columnNames);

		// Object Model for table content - Initialize with student info
			Object[][] data = new Object[classes.size()][columnNames.length];
			int rowCount=0;
			for (ClassEntity clsE: classes) {
				students = sService.findStudentById(clsE.getStudentId());
				Object[] row = new Object[columnNames.length];
				for(Student std : students) {
	        			row[0]=std.getId();
						row[1]=std.getFirstName();
						row[2]=std.getLastName();
						row[3]=std.getStudentId(); 
						row[4]=std.getType();
				
						grade = gService.readGradesByStudentId((Integer)std.getId());
						for(Grade grd:grade) {
							// System.out.println("GradeAttributes:"+grd);
							for(int j=5;j<columnNames.length-2;j++) {
								if(columnNames[j].split("\\(")[0].toString().toLowerCase().equals(grd.getAssignment().getName().toLowerCase())) {
									row[j]=grd.getGrade();
									break;
								}
							}
							if(calculateGrade(grade)!=null) {
								row[columnNames.length-2] = calculateGrade(grade)[1];
								row[columnNames.length-1] = calculateGrade(grade)[2];
							}
						}
		    			// Create a check method to see if student is already added to class
		    			data[rowCount] = row;
		    			rowCount++;
					}
//				}
			}
					
		// Fill table columns with empty values if already not filled
		setDefaultValues(rowCount,data,columnNames);
		
	  // Display the Data on table 
	  tableModel=new DefaultTableModel(data, columnNames){
			private static final long serialVersionUID = 1L;
			// This Method is to make a column not be Editable on Table.
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return column > data[0].length-3 || column <= 4 ? false: true; 
		    }
		    
		    // This Method Renders Checkbox on Table.
		    @Override
		    public Class<?> getColumnClass(int columnIndex) {
		        return getValueAt(0, columnIndex).getClass();
		    }
		};

		table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(200, 200));
		table.getTableHeader().setForeground(SystemColor.textHighlight);
		table.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 16));
		table.getTableHeader().setReorderingAllowed(false);
		Dimension d = table.getTableHeader().getPreferredSize();
		d.height = 30;
		d.width=180;
		table.getTableHeader().setSize(d);
		table.setFillsViewportHeight(true);
		table.setRowHeight(30);
		table.setFont(new Font("Georgia", Font.PLAIN, 16));
		// Hide the id column
		table.removeColumn(table.getColumnModel().getColumn(0));
		scrollPane.setViewportView(table);
		

	// Save button
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Integer assignmentId = null;
				Integer sid;
				Double grade = 0.0;
				GradeService gService = new GradeService();
				Grade stdGrade;
				System.out.println("Selected Muliple Rows: "+table.getSelectedRow());
				
				int rowIndex = table.getSelectedRow();
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(Dashboard.this, "Please Select a Row to Save!");
				}else {
					System.out.println(tableModel.getValueAt(rowIndex, 0));
					sid = (Integer) tableModel.getValueAt(rowIndex, 0);
					boolean sucess = false;
					for (int col = 4; col < table.getColumnCount()-2; col++){
						// Fields Integer assignmentId, Integer studentId, String note, Double grade
						for (Assignment asgnE: assignment) {
							if (asgnE.getName().equals(table.getColumnName(col).split("\\(")[0].toString())) {
								assignmentId = asgnE.getAssignmentId();
								grade = ((Number) table.getValueAt(rowIndex, col)).doubleValue();
								System.out.println("Grade:"+grade+" Val :"+table.getValueAt(rowIndex, col));
								break;
							}
						}
						if(assignmentId!=null) {
							try {
								List<Grade> org_grade = gService.readGradesByStudentId(sid);
								boolean update_grade_obj = false; 
								for(Grade org_g: org_grade) {
									if (org_g.getAssignmentId() == assignmentId) {
										org_g.setGrade(grade);
										gService.saveGrade(org_g);
										update_grade_obj = true;
										break;
									}
								}
								if(!update_grade_obj) {
									// Saving the Grades.
									stdGrade = new Grade(assignmentId,sid,"",grade);
									gService.saveGrade(stdGrade);
								}
								sucess = true;
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								sucess = false;
							}
						}
					}
					if(sucess){
						JOptionPane.showMessageDialog(Dashboard.this, "Successfully Saved the Selected a Row!");
					} else {
						JOptionPane.showMessageDialog(Dashboard.this, "Unable to Save the Selected a Row!");
					}
				}
			}
		});
		saveButton.setBounds(755, 485, 100, 25);
		panel.add(saveButton);
		
		JButton exportButton = new JButton("Export CVS");
		// TODO: Need to Come up with better logic
		exportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				DefaultTableModel model = (DefaultTableModel) table.getModel();
//				model.setRowCount(0);
				try {
				String result = System.getProperty("user.dir");
				boolean isApproved = true;
				JFileChooser chooser = new JFileChooser(); 
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle("Choose Directory");
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    //
			    // disable the "All files" option.
			    //
			    chooser.setAcceptAllFileFilterUsed(false);
			    //    
			    if (chooser.showOpenDialog(Dashboard.this) == JFileChooser.APPROVE_OPTION) { 
			      System.out.println("getCurrentDirectory(): " 
			         +  chooser.getCurrentDirectory());
			      System.out.println("getSelectedFile() : " 
			         +  chooser.getSelectedFile());
			      result = chooser.getSelectedFile().toString();
			      }
			    else {
			      System.out.println("Canceled");
			      isApproved = false;
			      }
			    if(isApproved) {
			    	System.out.println("Working Directory = " +
				              System.getProperty("user.dir"));
					  //String path =  System.getProperty("user.dir");
					  File file = new File(result + "/output.csv");
					  FileWriter writer = new FileWriter(file);
						CSVWriter csvWriter = new CSVWriter(writer); 
						List<String[]> values= new ArrayList<>();
						values.add(Arrays.copyOfRange(columnNames, 1, columnNames.length));
						for (int row = 0; row < table.getRowCount(); row++){
							String[] s = new String[table.getColumnCount()];
							for (int col = 0; col < table.getColumnCount(); col++){
								s[col] = table.getValueAt(row, col).toString();
							}
							values.add(s);
						}
						csvWriter.writeAll(values);;
				        csvWriter.close();
				        JOptionPane.showMessageDialog(Dashboard.this, "Successfully exported file in" + result);
			    		}  
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(exportButton);

		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(865, 485, 100, 25);
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
			}
		});
		panel.add(clearButton);
		
	}

	private void setDefaultValues(int rowCount, Object[][] data, String[] columnNames) {
		for(int i=0;i<rowCount;i++) {
			for(int j=5;j<columnNames.length;j++) {
				if (j == columnNames.length-1 && data[i][j] == null) {
					data[i][j]="";
				}
				else if (data[i][j]==null) {
					data[i][j]=new Integer(0);	
				}
			}
		}
	}
	
	private String[] calculateGrade(List<Grade> grade) {
		String[] returnOutput = new String[3];
		double sum = 0;
		int weight = 0;
		int total_weight = 0;	
		for(Grade r:grade) {
			if(!r.getAssignment().getIsOptional()) {
				total_weight+=r.getAssignment().getWeight();
			}
		}
		if(!grade.isEmpty()) {
			for(Grade grd : grade) {
				if (grd.getGrade()==0.0 && grd.getAssignment().getIsOptional()!=true) {
					sum += grd.getAssignment().getWeight();
				}else {
					sum += (grd.getGrade()/grd.getAssignment().getTotal())*grd.getAssignment().getWeight();
					if(grd.getAssignment().getIsOptional() && sum > total_weight ) {
						sum = total_weight;
					}
				}
				if(!grd.getAssignment().getIsOptional()) {
					weight += grd.getAssignment().getWeight();
				}
			}
			CalculateGrade finalGrade = new CalculateGrade();
			returnOutput[0]= ((Number)weight).toString();
			returnOutput[1]= ((Number)sum).toString();
			returnOutput[2]= finalGrade.grade(sum);
			return returnOutput;
		}
		System.out.println("grade == null");
		return returnOutput;
	}
}
