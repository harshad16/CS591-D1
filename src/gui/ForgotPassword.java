package src.gui;

import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
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
import javax.swing.JComboBox;
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

public class ForgotPassword extends JFrame {

	/**
	 * ForgotPassword Method: User can reset the password if forgotten.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JTextField securityAnswerText;

	public ForgotPassword() {
		setBounds(100, 100, 1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel logoLabel = new JLabel();
		logoLabel.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/logo.png")));
		logoLabel.setBounds(561, 13, 200, 200);
		contentPane.add(logoLabel);
		
		JLabel usernameLabel = new JLabel("USERNAME");
		usernameLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		usernameLabel.setIcon(new ImageIcon(ForgotPassword.class.getResource("/src/misc/user_32x32.png")));
		usernameLabel.setBounds(375, 261, 200, 35);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("NEW PASSWORD");
		passwordLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		passwordLabel.setIcon(new ImageIcon(ForgotPassword.class.getResource("/src/misc/password_32x32.png")));
		passwordLabel.setBounds(375, 438, 200, 35);
		contentPane.add(passwordLabel);
		
		JLabel securityQuestionLabel = new JLabel("Security Question");
		securityQuestionLabel.setIcon(new ImageIcon(ForgotPassword.class.getResource("/src/misc/question_32x32.png")));
		securityQuestionLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		securityQuestionLabel.setBounds(375,322, 200, 35);
		contentPane.add(securityQuestionLabel);
		
		JLabel securityAnswerLabel = new JLabel("Security Answer");
		securityAnswerLabel.setIcon(new ImageIcon(ForgotPassword.class.getResource("/src/misc/question_32x32.png")));
		securityAnswerLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		securityAnswerLabel.setBounds(375, 382, 200, 35);
		contentPane.add(securityAnswerLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Georgia", Font.PLAIN, 16));
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(610, 261, 345, 35);
		contentPane.add(usernameTextField);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Georgia", Font.PLAIN, 16));
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(610, 438, 345, 35);
		contentPane.add(passwordTextField);
		
		JComboBox<String> securityQuestionText = new JComboBox<String>();
		securityQuestionText.setEditable(true);
		securityQuestionText.setFont(new Font("Georgia", Font.PLAIN, 16));
		securityQuestionText.setBounds(610, 322, 345, 35);
		SecurityQuestions sq = new SecurityQuestions();
		securityQuestionText.insertItemAt("", 0); 
		for (int i=0; i<sq.getAllQuestions().size();i++) {
    		securityQuestionText.addItem((String) sq.getAllQuestions().get(i));
    	}
    	contentPane.add(securityQuestionText);

		securityAnswerText = new JTextField();
		securityAnswerText.setFont(new Font("Georgia", Font.PLAIN, 16));
		securityAnswerText.setColumns(10);
		securityAnswerText.setBounds(610, 382, 345, 35);
		contentPane.add(securityAnswerText);

		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String userName = usernameTextField.getText();
					String password = ((Integer)String.valueOf(passwordTextField.getPassword()).hashCode()).toString();
					String securityQuestion = (String) securityQuestionText.getSelectedItem();
					String securityQuestionAnswer = securityAnswerText.getText();
					User user = checkUserAndSecurityQuestion(userName, password, securityQuestion,securityQuestionAnswer);
					if(user != null) {
						UserService uService = new UserService();
						uService.saveUser(user);
						JOptionPane.showMessageDialog(contentPane, "Password has been modified!");	
					}
				} catch (SQLException exception) {
					exception.printStackTrace();
				}
			}	
		});
		
		updateButton.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					try {
						String userName = usernameTextField.getText();
						String password = ((Integer)String.valueOf(passwordTextField.getPassword()).hashCode()).toString();
						String securityQuestion = (String) securityQuestionText.getSelectedItem();
						String securityQuestionAnswer = securityAnswerText.getText();
						User user = checkUserAndSecurityQuestion(userName, password, securityQuestion,securityQuestionAnswer);
						if(user != null) {
							UserService uService = new UserService();
							uService.saveUser(user);
							JOptionPane.showMessageDialog(contentPane, "Password has been modified!");	
						}
					} catch (SQLException exception) {
						exception.printStackTrace();
					}		        
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {}
		});
		
		
		updateButton.setFont(new Font("Georgia", Font.BOLD, 16));
		updateButton.setBounds(598, 530, 122, 49);
		contentPane.add(updateButton);
		
		JLabel returnLabel = new JLabel();
		returnLabel.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/back.png")));
		returnLabel.setBounds(30, 30, 50, 40);
		contentPane.add(returnLabel, BorderLayout.WEST);
		returnLabel.addMouseListener(new MouseListener () {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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

		JLabel signupLabel = new JLabel("SignUp");
		signupLabel.setForeground(Color.BLUE);
		signupLabel.setBounds(632, 592, 56, 16);
		contentPane.add(signupLabel);
		signupLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// Goto SignUp page
				Signup sign_up = new Signup();
				sign_up.setVisible(true);
				setVisible(false);
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
	}

	public User checkUserAndSecurityQuestion(String userName, String password, String securityQuestion,String securityQuestionAnswer ) throws SQLException{
		UserService uService = new UserService();
		List<User> users = uService.findUserByUserName(userName);
		if(users.size() > 0) {
			User foundUser = users.get(0);
			if(foundUser.getSecurityQuestion().equals(securityQuestion)) {
				if(foundUser.getSecurityQuestionAnswer().equals(securityQuestionAnswer)) {
					User u =  new User(userName, password, securityQuestion , securityQuestionAnswer);
					u.setId(foundUser.getId());
					return u;
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Security question or answer is not correct");	
				}
			}else {
				JOptionPane.showMessageDialog(contentPane, "Security question or answer is not correct");	
			}		
		}
		return null;
	}
}
