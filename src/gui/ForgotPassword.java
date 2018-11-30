package src.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import src.entities.User;
import src.service.UserService;

public class ForgotPassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField_4;
	private JPasswordField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
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
	public ForgotPassword() {
		setBounds(100, 100, 1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/logo.png")));
		lblNewLabel.setBounds(561, 13, 200, 200);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 16));
		lblNewLabel_1.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/user.png")));
		lblNewLabel_1.setBounds(460, 236, 174, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NEW PASSWORD");
		lblNewLabel_2.setFont(new Font("Georgia", Font.BOLD, 16));
		lblNewLabel_2.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/password.png")));
		lblNewLabel_2.setBounds(460, 485, 204, 60);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/question.png")));
		lblSecurityQuestion.setFont(new Font("Georgia", Font.BOLD, 16));
		lblSecurityQuestion.setBounds(460, 324, 204, 60);
		contentPane.add(lblSecurityQuestion);
		
		JLabel lblSecurityAnswer = new JLabel("Security Answer");
		lblSecurityAnswer.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/question.png")));
		lblSecurityAnswer.setFont(new Font("Georgia", Font.BOLD, 16));
		lblSecurityAnswer.setBounds(460, 401, 204, 60);
		contentPane.add(lblSecurityAnswer);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Georgia", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(676, 249, 164, 35);
		contentPane.add(textField_4);
		
		textField_5 = new JPasswordField();
		textField_5.setFont(new Font("Georgia", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(676, 493, 164, 35);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Georgia", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(676, 337, 164, 35);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Georgia", Font.PLAIN, 16));
		textField_7.setColumns(10);
		textField_7.setBounds(676, 414, 164, 35);
		contentPane.add(textField_7);
		
		JButton btnNewButton = new JButton("Save");
		//validation part
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String userName = textField_4.getText();
					String password = String.valueOf(textField_5.getPassword());
					String securityQuestion = textField_6.getText();
					String securityQuestionAnswer = textField_7.getText();
					User user = checkUserAndSecurityQuestion(userName, password, securityQuestion,securityQuestionAnswer);
					if(user != null) {
						UserService uService = new UserService();
						uService.saveUser(user);
						JOptionPane.showMessageDialog(contentPane, "Password has been modified!");	
					}
				} catch (SQLException exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}
			}
			
		});
		
		
		
		
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 16));
		btnNewButton.setBounds(617, 587, 112, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Return");
		lblNewLabel_3.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/back.png")));
		lblNewLabel_3.setBounds(30, 30, 56, 41);
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
	}
	
	public User checkUserAndSecurityQuestion(String userName, String password, String securityQuestion,String securityQuestionAnswer ) throws SQLException{
		UserService uService = new UserService();
		List<User> users = uService.findUserByUserName(userName);
		System.out.println(users.size());
		if(users.size() > 0) {
			User foundUser = users.get(0);
			System.out.println(foundUser);
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
