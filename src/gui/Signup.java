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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Signup extends JFrame {

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
					Signup frame = new Signup();
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
	public Signup() {
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
		lblNewLabel_1.setBounds(460, 248, 174, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Georgia", Font.BOLD, 16));
		lblNewLabel_2.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/password.png")));
		lblNewLabel_2.setBounds(460, 335, 174, 60);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/question.png")));
		lblSecurityQuestion.setFont(new Font("Georgia", Font.BOLD, 16));
		lblSecurityQuestion.setBounds(460, 419, 204, 60);
		contentPane.add(lblSecurityQuestion);
		
		JLabel lblSecurityAnswer = new JLabel("Security Answer");
		lblSecurityAnswer.setIcon(new ImageIcon(Signup.class.getResource("/src/misc/question.png")));
		lblSecurityAnswer.setFont(new Font("Georgia", Font.BOLD, 16));
		lblSecurityAnswer.setBounds(460, 499, 204, 60);
		contentPane.add(lblSecurityAnswer);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Georgia", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(676, 261, 164, 35);
		contentPane.add(textField_4);
		
		textField_5 = new JPasswordField();
		textField_5.setFont(new Font("Georgia", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(676, 343, 164, 35);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Georgia", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(676, 419, 164, 35);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Georgia", Font.PLAIN, 16));
		textField_7.setColumns(10);
		textField_7.setBounds(676, 496, 164, 35);
		contentPane.add(textField_7);
		
		JButton btnNewButton = new JButton("Register");
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

}
