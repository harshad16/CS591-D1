package src.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import src.entities.SecurityQuestions;
import src.entities.User;
import src.service.UserService;
import javax.swing.JComboBox;
import java.awt.Color;

public class Signup extends JFrame {

	/**
	 * SignUp Method: User Can register themselves with GradeIn  by Registering.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JTextField securityAnswerTextField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Signup() {
		setBounds(100, 100, 1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		
		JLabel logoLabel = new JLabel();
		logoLabel.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/logo.png")));
		logoLabel.setBounds(550, 15, 200, 200);
		contentPane.add(logoLabel);
		
		JLabel usernameLabel = new JLabel("USERNAME");
		usernameLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		usernameLabel.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/user_32x32.png")));
		usernameLabel.setBounds(375, 261, 200, 35);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		passwordLabel.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/password_32x32.png")));
		passwordLabel.setBounds(375, 317, 200, 35);
		contentPane.add(passwordLabel);
		
		JLabel securityQuestionLabel = new JLabel("Security Question");
		securityQuestionLabel.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/question_32x32.png")));
		securityQuestionLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		securityQuestionLabel.setBounds(375, 382, 200, 35);
		contentPane.add(securityQuestionLabel);
		
		JLabel securityAnswerLabel = new JLabel("Security Answer");
		securityAnswerLabel.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/question_32x32.png")));
		securityAnswerLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		securityAnswerLabel.setBounds(375, 438, 200, 35);
		contentPane.add(securityAnswerLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Georgia", Font.PLAIN, 16));
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(610, 261, 345, 35);
		contentPane.add(usernameTextField);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Georgia", Font.PLAIN, 16));
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(610, 317, 345, 35);
		contentPane.add(passwordTextField);
		
		JComboBox<String> securityQuestionText = new JComboBox();
		securityQuestionText.setEditable(true);
		securityQuestionText.setFont(new Font("Georgia", Font.PLAIN, 16));
		securityQuestionText.setBounds(610, 382, 345, 35);
		SecurityQuestions sq = new SecurityQuestions();
		securityQuestionText.insertItemAt("", 0); // Option to Write your own question or select from below
		for (int i=0; i<sq.getAllQuestions().size();i++) {
    		securityQuestionText.addItem((String) sq.getAllQuestions().get(i));
    	}
    	contentPane.add(securityQuestionText);
		
		securityAnswerTextField = new JTextField();
		securityAnswerTextField.setFont(new Font("Georgia", Font.PLAIN, 16));
		securityAnswerTextField.setColumns(10);
		securityAnswerTextField.setBounds(610, 438, 345, 35);
		contentPane.add(securityAnswerTextField);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = usernameTextField.getText();
				char[] password = passwordTextField.getPassword();
				String securityQuestion = (String) securityQuestionText.getSelectedItem();
				String securityQuestionAnswer = securityAnswerTextField.getText();
				if (validation(userName, password, securityQuestion)) {
					User user = new User(userName, ((Integer)String.valueOf(password).hashCode()).toString(), securityQuestion, securityQuestionAnswer);	
					try {
						signUpforUser(user);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		registerButton.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
		        	String userName = usernameTextField.getText();
					char[] password = passwordTextField.getPassword();
					String securityQuestion = (String) securityQuestionText.getSelectedItem();
					String securityQuestionAnswer = securityAnswerTextField.getText();
					if (validation(userName, password, securityQuestion)) {
						User user = new User(userName, ((Integer)String.valueOf(password).hashCode()).toString(), securityQuestion, securityQuestionAnswer);	
						try {
							signUpforUser(user);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
		        }
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {}
		});
		registerButton.setFont(new Font("Georgia", Font.BOLD, 16));
		registerButton.setBounds(598, 522, 130, 41);
		contentPane.add(registerButton);
		
		JLabel returnLabel = new JLabel();
		returnLabel.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/back.png")));
		returnLabel.setBounds(30, 30, 50, 40);
		contentPane.add(returnLabel, BorderLayout.WEST);
		returnLabel.addMouseListener(new MouseListener () {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Return to Index page(Login)
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

		
		JLabel forgotPasswordLabel = new JLabel("Forgot Password?");
		forgotPasswordLabel.setForeground(Color.BLUE);
		forgotPasswordLabel.setBounds(608, 576, 107, 16);
		contentPane.add(forgotPasswordLabel);
		forgotPasswordLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Goto Forgot Password page
				ForgotPassword forgot_password = new ForgotPassword();
				forgot_password.setVisible(true);
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

	}
	
	public boolean validation(String userName, char[] password, String securityQuestion) {
		if(userName == null || userName.length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Username cannot be nul!");
			return false;
		}	
		if(password == null || password.length == 0) {
			JOptionPane.showMessageDialog(contentPane, "Password cannot be null!");
			return false;
		}
		if(securityQuestion == null || securityQuestion == "") {
			JOptionPane.showMessageDialog(contentPane, "Security question cannot be null!\n Write your own question or select from dropdown");
			return false;
		}
		return true;
	}
	
	public void signUpforUser(User u) throws SQLException {
		UserService uService = new UserService();
		List<User> dupUser = uService.findUserByUserName(u.getUserName());
		if(!dupUser.isEmpty()) {
			JOptionPane.showMessageDialog(contentPane, "User name already exist!");	
		}
		else {
			uService.saveUser(u);
			JOptionPane.showMessageDialog(contentPane, "Sucess!");
			List<User> userList = uService.findUserByUserName(u.getUserName());
			if(userList.size() != 0) {
				User usr = userList.get(0);
				Home _home = new Home(usr);
				_home.setVisible(true);
				setVisible(false);
			}
		}
	}
}
