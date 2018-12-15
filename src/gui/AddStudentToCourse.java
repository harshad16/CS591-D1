package src.gui;

import src.entities.ClassEntity;
import src.entities.Course;
import src.entities.Student;
import src.entities.User;
import src.service.ClassService;
import src.service.StudentService;
import java.sql.SQLException;
import java.util.List;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class AddStudentToCourse extends JPanel {
	/**
	 * Class for adding students to course.
	 */

	private static final long serialVersionUID = 1L;
	private Course course;
	private JTextField searchText;
	private String searchType;
	private List<Student> students;
	private Object[][] rst;
	private JScrollPane scrollPane;
	private JTable resultTable;
	private DefaultTableModel tableModel;
	private User user;

	public AddStudentToCourse() {
		initialize();
	}
	
	public AddStudentToCourse(Course c, User u) {
		this.course = c;
		this.user = u;
		initialize();
	}
	
	public void initialize() {
		setBounds(215, 146, 1021, 527);
		setLayout(null);
		
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("Georgia", Font.PLAIN, 14));
		saveButton.setBounds(755, 473, 113, 37);
		add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {	
					for (int row = 0; row < resultTable.getRowCount(); row++){
						if ((resultTable.getValueAt(row, resultTable.getColumnCount()-1).toString()== "true")) {
			        		Integer sid = (Integer) tableModel.getValueAt(row, 0);
			        		ClassService  clsService = new ClassService();
			        		List<ClassEntity> classes;		
			        		try {
								classes = clsService.readClasses(course.getId());
								boolean already=false;
								for (ClassEntity clsE: classes) {
				                	// System.out.println("ClassAttributes:"+clsE);
				                	if(sid == clsE.getStudentId()) {
				                		already = true;
				                		break;
				                    }
				                }
								if (!already) {
									ClassEntity c1ass1 = new ClassEntity(course.getId(), sid);
									clsService.saveClass(c1ass1);
								}
				        		
			        		} catch (SQLException e) {
								e.printStackTrace();
							}
		        		
						}
						else {
							Integer sid = (Integer) tableModel.getValueAt(row, 0);
			        		ClassService  clsService = new ClassService();
			        		List<ClassEntity> classes;		
			        		try {
								classes = clsService.readClasses(course.getId());
								for (ClassEntity clsE: classes) {
				                	// System.out.println("ClassAttributes:"+clsE);
				                	if(sid == clsE.getStudentId()) {
				                		int s_index=0;
				                		for(s_index=0;s_index<clsE.getStudents().size();s_index++) {
				                			if(clsE.getStudents().get(s_index).getId()==sid) {
				                				break;
				                			}
				                		}
				                    	String full_name = clsE.getStudents().get(s_index).getFirstName()+" "+clsE.getStudents().get(s_index).getLastName();
				                    	if (JOptionPane.showConfirmDialog(AddStudentToCourse.this, "Are you sure? You want to remove "+full_name+" from the course", "WARNING",
				                    	        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					                    	clsService.deleteClass(clsE);
					                    	// System.out.println(" "+clsE.getStudentId());
				                    	} else {
				                    	    // no option
				                    	}
				                    }
				                }
				        		
			        		} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
					JOptionPane.showMessageDialog(AddStudentToCourse.this, "Successfully added Students!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(AddStudentToCourse.this, "Please select student");
				}
			}
		});

		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
					model.setRowCount(0);
					searchText.setText("");
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(AddStudentToCourse.this, "Please select student");
				}
			}
		});
		clearButton.setBounds(901, 473, 97, 37);
		clearButton.setFont(new Font("Georgia", Font.PLAIN, 14));
		add(clearButton);
		
		searchText = new JTextField();
		searchText.setBounds(214, 50, 518, 37);
		add(searchText);
		searchText.setColumns(10);
		
		JLabel searchLabel = new JLabel("Search: ");
		searchLabel.setIcon(new ImageIcon(AddStudentToCourse.class.getResource("/src/misc/search_32x32.png")));
		searchLabel.setFont(new Font("Georgia", Font.PLAIN, 16));
		searchLabel.setBounds(93, 49, 109, 37);
		add(searchLabel);
		
		String[] category = {"BUid", "First Name", "Last Name"};
		JComboBox<String> comboBox = new JComboBox<String>(category);
		searchType = "BUid";
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//store search filter 
				searchType = (String)comboBox.getSelectedItem();
			}
		});
		comboBox.setBounds(755, 50, 130, 37);
		add(comboBox);
		
		JLabel categoryLabel = new JLabel("Category");
		categoryLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		categoryLabel.setBounds(755, 27, 97, 16);
		add(categoryLabel);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchStudent();
			}
		});
		searchButton.setBounds(901, 50, 97, 37);
		add(searchButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 145, 905, 297);
		add(scrollPane);
		
		JLabel stdDBLabel = new JLabel("Add Students to DB:");
		stdDBLabel.setIcon(new ImageIcon(AddStudentToCourse.class.getResource("/src/misc/student_24x24.png")));
		stdDBLabel.setBounds(93, 460, 150, 25);
		add(stdDBLabel);
		
		JButton stdDBButton = new JButton("Add students to DB");
		stdDBButton.setSelectedIcon(null);
		stdDBButton.setBounds(93, 489, 150, 25);
		stdDBButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GeneralFrame _addstudent = new GeneralFrame("Student", user);
				_addstudent.setVisible(true);
				JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
				topFrame.setVisible(false);
			}
		});
		add(stdDBButton);
	}
	
	private void searchStudent() {
		String[] columnNames = {"sid(hidden)","First Name",
                "Last Name",
                "BU-ID", 
                "Year", 
                "Degree",
                "Add to Course"};
		if(searchText.getText().equals("")) {
			JOptionPane.showMessageDialog(AddStudentToCourse.this, "Cannot be null!");	
		}
		else {
			StudentService sService = new StudentService();
			try {
				//Implement this by search id in class DB
				switch(searchType) {
				case "BUid":
					students = sService.findStudentByBUId(searchText.getText());
					break;
				case  "First Name":
					students = sService.findStudentByFirstName(searchText.getText());
					break;
				case "Last Name":
					students = sService.findStudentByLastName(searchText.getText());
					break;
				}
				int count = 0;
				if(!students.isEmpty()) {
					rst = new Object[students.size()][columnNames.length];
					for(Student s : students) {
						// Create a check method to see if student is already added to class
						ClassService  clsService = new ClassService();
		        		List<ClassEntity> classes;		
		        		boolean already=false;
		        		try {
							classes = clsService.readClasses(course.getId());
							for (ClassEntity clsE: classes) {
			                	// System.out.println("ClassAttributes:"+clsE);
			                	if(s.getId() == clsE.getStudentId()) {
			                		// validation if student already exists in class
			                    	already = true;
			                    	break;
			                    	// System.out.println(already+" "+clsE.getStudentId());
			                    }
			                }		
			        		
		        		} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        		Object[] row = {s.getId(),s.getFirstName(),s.getLastName(), s.getStudentId(), s.getYear(), s.getType(),already};
						rst[count] = row;
						count++;
					}

					tableModel=new DefaultTableModel(rst, columnNames){
						private static final long serialVersionUID = 1L;
						// This Method is to make a column not be Editable on Table.
					    @Override
					    public boolean isCellEditable(int row, int column) {
					        return column == rst[0].length-1 ? true: false; 
					    }

					    // This Method Renders Checkbox on Table.
					    @Override
					    public Class<?> getColumnClass(int columnIndex) {
					        return getValueAt(0, columnIndex).getClass();
					    }
					};

					resultTable = new JTable(tableModel);
					resultTable.setPreferredScrollableViewportSize(new Dimension(400, 400));
					resultTable.getTableHeader().setForeground(SystemColor.textHighlight);
					resultTable.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 16));
					resultTable.getTableHeader().setReorderingAllowed(false);
					Dimension d = resultTable.getTableHeader().getPreferredSize();
					d.height = 30;
					resultTable.getTableHeader().setSize(d);
					// Hide the id column
					resultTable.removeColumn(resultTable.getColumnModel().getColumn(0));
					resultTable.setFillsViewportHeight(true);
					resultTable.setRowHeight(30);
					resultTable.setFont(new Font("Georgia", Font.PLAIN, 16));
					scrollPane.setViewportView(resultTable);
					}
				}catch(SQLException e) {}
			}

	}
}
