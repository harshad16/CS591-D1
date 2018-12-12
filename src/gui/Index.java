package src.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import src.entities.User;
import src.service.UserService;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Index {

	/**
	 * TODO: Write the Doc
	 */
	public JFrame mainFrame;
	private JTextField usernameText;
	private JPasswordField passwordText;
	private User user;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index window = new Index();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Index() {
		initialize();
	}

	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 1280, 720);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		JLabel logoLabel = new JLabel();
		logoLabel.setIcon(new ImageIcon(Index.class.getResource("/src/misc/logo.png")));
		logoLabel.setBounds(561, 57, 200, 200);
		mainFrame.getContentPane().add(logoLabel);
		
		JLabel usernameLabel = new JLabel("USERNAME");
		usernameLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		usernameLabel.setIcon(new ImageIcon(Index.class.getResource("/src/misc/user_32x32.png")));
		usernameLabel.setBounds(462, 313, 174, 60);
		mainFrame.getContentPane().add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		passwordLabel.setIcon(new ImageIcon(Index.class.getResource("/src/misc/password_32x32.png")));
		passwordLabel.setBounds(462, 386, 174, 60);
		mainFrame.getContentPane().add(passwordLabel);
		
		usernameText = new JTextField();
		usernameText.setFont(new Font("Georgia", Font.PLAIN, 16));
		usernameText.setBounds(658, 326, 164, 35);
		mainFrame.getContentPane().add(usernameText);
		usernameText.setColumns(10);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(658, 400, 164, 35);
		mainFrame.getContentPane().add(passwordText);
		passwordText.setColumns(10);
		
		JButton loginButton = new JButton("LogIn");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//validation starts here
				try {
				String userName = usernameText.getText();
				char[] password = passwordText.getPassword();
				user = new User(userName, ((Integer)String.valueOf(password).hashCode()).toString());
				boolean isUser;
					isUser = checkUserAndPassword(user);
					if(isUser) {
						//if correct, new window to show other logic
						Home _home = new Home(user);
						_home.setVisible(true);
						mainFrame.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(mainFrame, "Password or Username is not correct");	
					}	
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		loginButton.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					//validation starts here
					try {
					String userName = usernameText.getText();
					char[] password = passwordText.getPassword();
					user = new User(userName, ((Integer)String.valueOf(password).hashCode()).toString());
					boolean isUser;
						isUser = checkUserAndPassword(user);
						if(isUser) {
							//if correct, new window to show other logic	
							Home _home = new Home(user);
							_home.setVisible(true);
							mainFrame.setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(mainFrame, "Password or Username is not correct");	
						}	
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
		        }
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {}
		});
		loginButton.setFont(new Font("Georgia", Font.BOLD, 16));
		loginButton.setBounds(610, 543, 122, 46);
		mainFrame.getContentPane().add(loginButton);
		
		JLabel forgotPasswordButton = new JLabel("Forgot Password?");
		forgotPasswordButton.addMouseListener(new MouseListener () {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Goto Forgot Password page
				ForgotPassword forgot_password = new ForgotPassword();
				forgot_password.setVisible(true);
				mainFrame.setVisible(false);	
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
		forgotPasswordButton.setForeground(Color.BLUE);
		forgotPasswordButton.setBounds(590, 603, 107, 16);
		mainFrame.getContentPane().add(forgotPasswordButton);
		
		JLabel signupButton = new JLabel("SignUp");
		signupButton.addMouseListener(new MouseListener () {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Goto SignUp page
				Signup sign_up = new Signup();
				sign_up.setVisible(true);
				mainFrame.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}
		});
		signupButton.setForeground(Color.BLUE);
		signupButton.setBounds(705, 602, 56, 16);
		mainFrame.getContentPane().add(signupButton);
		
	}

	private boolean checkUserAndPassword(User u) throws SQLException{
		UserService uService = new UserService();
		List<User> userList = uService.findUserByUserName(u.getUserName());
		if(userList.size() != 0) {
			if(userList.get(0).getPassword().equals(u.getPassword())) {
				user = userList.get(0);
				return true;
			}
		}
		return false;
	}
}
