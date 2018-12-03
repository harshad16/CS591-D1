package src.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AddStudentToCourse extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AddStudentToCourse() {
		setBounds(215, 146, 1021, 527);
		setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.setBounds(755, 485, 97, 25);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.setBounds(864, 485, 97, 25);
		add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(214, 50, 518, 37);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewAbel = new JLabel("Search :");
		lblNewAbel.setIcon(new ImageIcon(AddStudentToCourse.class.getResource("/src/misc/search_32x32.png")));
		lblNewAbel.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblNewAbel.setBounds(93, 49, 109, 37);
		add(lblNewAbel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(755, 50, 130, 37);
		add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblNewLabel.setBounds(755, 27, 97, 16);
		add(lblNewLabel);
		
		
		String[] columnNames = {"First Name",
                "Last Name",
                "BU-ID",
                "Project",
                "Final",
                "Grade"};
		Object[][] data = {
			    {"Kathy", "Smith",
			     "U123456789", new Integer(95), new Integer(93), "A"},
			    {"John", "Doe",
			     "U87654321", new Integer(93), new Integer(93), "A"}
			};
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(901, 50, 97, 37);
		add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 145, 905, 327);
		add(scrollPane);
		
		
		JTable table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
		

	}
}
