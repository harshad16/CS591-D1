package src.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GeneralFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel usernameText;
	private String userName;

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
		usernameText.setText(userName);
	}

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
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/user_32x32.png")));
		usernameLabel.setFont(new Font("Georgia", Font.BOLD, 14));
		usernameLabel.setBounds(1025, 50, 125, 30);
		contentPane.add(usernameLabel);
		
		usernameText = new JLabel();
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
				// TODO Auto-generated method stub
				Home _home = new Home(userName);
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
		
		JLabel homeLabel = new JLabel();
		homeLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/src/misc/home.png")));
		homeLabel.addMouseListener(new MouseListener () {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home _home = new Home(userName);
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
		
	}

}
