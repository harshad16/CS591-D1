package src.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private String userName;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Home() {
		initComponents();
	}
	
	public Home(String userName) {
		this();
		this.userName = userName;
		JLabel lblNewLabel_1 = new JLabel(userName);
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(1149, 54, 74, 22);
		contentPane.add(lblNewLabel_1);
		
	}
	
	public void initComponents() {
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
		
//		JLabel lblNewLabel_1 = new JLabel("New label");
//		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 14));
//		lblNewLabel_1.setBounds(1149, 54, 74, 22);
//		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Return");
		lblNewLabel_3.setIcon(new ImageIcon(Home.class.getResource("/src/misc/back.png")));
		lblNewLabel_3.setBounds(12, 23, 56, 41);
		contentPane.add(lblNewLabel_3, BorderLayout.WEST);
		lblNewLabel_3.addMouseListener(new MouseListener () {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Index _index = new Index();
				_index.frame.setVisible(true);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 146, 898, 527);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/src/misc/add_course_.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GeneralFrame _addcourse = new GeneralFrame("Course");
				_addcourse.setUsername(userName);
				_addcourse.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(332, 101, 174, 160);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Add Course:");
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(49, 13, 121, 43);
		panel.add(lblNewLabel_2);
		
		//TODO: need to remove hard code
		JButton btnCs = new JButton("<html>CS591-D1<br>Fall-2018</html>");
		btnCs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dashboard _dashboard = new Dashboard();
				_dashboard.setUserName(userName);
				_dashboard.setVisible(true);
				setVisible(false);
			}
		});
		btnCs.setFont(new Font("Georgia", Font.PLAIN, 16));
		btnCs.setBounds(49, 101, 174, 160);
		panel.add(btnCs);
		
		JButton btnNewButton_1 = new JButton("Add Student in DB");
		btnNewButton_1.setIcon(new ImageIcon(Home.class.getResource("/src/misc/add_users.png")));
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 16));
		btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GeneralFrame _addstudent = new GeneralFrame("Student");
				_addstudent.setUsername(userName);
				_addstudent.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(1027, 146, 163, 105);
		contentPane.add(btnNewButton_1);
		
		
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
		lblHome.setBounds(69, 23, 33, 41);
		contentPane.add(lblHome);
	}
}
