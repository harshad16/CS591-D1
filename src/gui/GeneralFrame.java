package src.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GeneralFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1;
	private String userName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralFrame frame = new GeneralFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setUsername(String userName) {
		this.userName = userName;
		lblNewLabel_1.setText(userName);
	}

	/**
	 * Create the frame.
	 */
	public GeneralFrame() {
		intialCommonComponent();
	}
	
	public GeneralFrame(String panel_type) {
		this();
		if (panel_type=="Course") {
			AddCourse obj = new AddCourse();
	        obj.setVisible(true);
	        contentPane.add(obj);
	        ((JPanel) contentPane).revalidate();
	        contentPane.repaint();	
		}
		else if (panel_type=="Student") {
			AddStudentDB obj = new AddStudentDB();
			obj.setVisible(true);
	        contentPane.add(obj);
	        ((JPanel) contentPane).revalidate();
	        contentPane.repaint();
		}
		
	}
	
	public void intialCommonComponent() {
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
		
		lblNewLabel_1 = new JLabel("newLabel");
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(1149, 54, 74, 22);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_3 = new JLabel("Return");
		lblNewLabel_3.setIcon(new ImageIcon(Home.class.getResource("/src/misc/back.png")));
		lblNewLabel_3.setBounds(12, 23, 56, 41);
		contentPane.add(lblNewLabel_3, BorderLayout.WEST);
		lblNewLabel_3.addMouseListener(new MouseListener () {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Home _home = new Home(userName);
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
		
		JLabel lblHome = new JLabel("");
		lblHome.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/home.png")));
		lblHome.addMouseListener(new MouseListener () {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Home _home = new Home(userName);
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
