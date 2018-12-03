package src.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String userName;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setBounds(100, 100, 1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/src/misc/user.png")));
		lblNewLabel.setBounds(1012, 29, 42, 77);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblUsername.setBounds(1066, 51, 102, 29);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(1149, 54, 74, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Return");
		lblNewLabel_3.setIcon(new ImageIcon(Home.class.getResource("/src/misc/back.png")));
		lblNewLabel_3.setBounds(30, 30, 50, 41);
		contentPane.add(lblNewLabel_3, BorderLayout.WEST);
		lblNewLabel_3.addMouseListener(new MouseListener () {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Home _home = new Home();
				_home.setVisible(true);
				setVisible(false);
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		JLabel lblNewLabel_2 = new JLabel("Course Name:");
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(215, 22, 95, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Course Id:");
		lblNewLabel_4.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(215, 51, 95, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblYear.setBounds(215, 80, 95, 26);
		contentPane.add(lblYear);
		
		JLabel lblJava = new JLabel("Java");
		lblJava.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblJava.setBounds(322, 20, 263, 26);
		contentPane.add(lblJava);
		
		JLabel lblCs = new JLabel("CS591");
		lblCs.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblCs.setBounds(322, 52, 251, 26);
		contentPane.add(lblCs);
		
		JLabel lblFall = new JLabel("Fall 2018");
		lblFall.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblFall.setBounds(322, 80, 251, 26);
		contentPane.add(lblFall);
		
		JLabel lblHome = new JLabel("");
		lblHome.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/home.png")));
		lblHome.addMouseListener(new MouseListener () {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Home _home = new Home();
				_home.setVisible(true);
				setVisible(false);
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		lblHome.setBounds(92, 29, 33, 41);
		contentPane.add(lblHome);
		
		JButton btnNewButton = new JButton("Add Assignment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard _assgn = new Dashboard("Assignment");
				_assgn.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(30, 309, 133, 101);
		contentPane.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/add_course.png")));
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JButton btnNewButton_1 = new JButton("Add Students");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard _std = new Dashboard("Student");
				_std.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(30, 423, 133, 101);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/add_course.png")));
		btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JButton btnViewStats = new JButton("View Stats");
		btnViewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard _stats = new Dashboard("Stats");
				_stats.setVisible(true);
				setVisible(false);
			}
		});
		btnViewStats.setBounds(30, 537, 133, 103);
		contentPane.add(btnViewStats);
		btnViewStats.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/view_stats.png")));
		btnViewStats.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnViewStats.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard _dashboard = new Dashboard("");
				_dashboard.setVisible(true);
				setVisible(false);
			}
		});
		btnDashboard.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/dashboard.png")));
		btnDashboard.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDashboard.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDashboard.setBounds(30, 200, 133, 96);
		contentPane.add(btnDashboard);
			
	}
	
	public Dashboard(String panel_type){
		this();
		if (panel_type.equals("Assignment")) {
			AddAssignments obj = new AddAssignments();
	        obj.setVisible(true);
	        contentPane.add(panel_type,obj);
	        ((JPanel) contentPane).revalidate();
	        contentPane.repaint();
		}
		else if (panel_type.equals("Student")) {
			AddStudentToCourse obj = new AddStudentToCourse();
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
			JPanel panel = new JPanel();
			panel.setBounds(215, 146, 1021, 527);
			panel.setLayout(null);
			contentPane.add(panel_type,panel);
			((JPanel) contentPane).revalidate();
			contentPane.repaint();
			
	        String[] columnNames = {"First Name",
	                "Last Name",
	                "Sport",
	                "# of Years",
	                "Vegetarian"};
			Object[][] data = {
				    {"Kathy", "Smith",
				     "Snowboarding", new Integer(5), new Boolean(false)},
				    {"John", "Doe",
				     "Rowing", new Integer(3), new Boolean(true)},
				    {"Sue", "Black",
				     "Knitting", new Integer(2), new Boolean(false)},
				    {"Jane", "White",
				     "Speed reading", new Integer(20), new Boolean(true)},
				    {"Joe", "Brown",
				     "Pool", new Integer(10), new Boolean(false)}
				};
			
			
			table = new JTable(data, columnNames);
			table.setBounds(12, 13, 949, 459);
			panel.add(table);
			
			JButton btnNewButton_2 = new JButton("Save");
			btnNewButton_2.setBounds(755, 485, 97, 25);
			panel.add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("Clear");
			btnNewButton_3.setBounds(864, 485, 97, 25);
			panel.add(btnNewButton_3);
		}
	}
}
