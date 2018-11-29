package src.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Statistics extends JPanel {

	/**
	 * Create the panel.
	 */
	public Statistics() {
		
		setBounds(215, 146, 1021, 527);
		setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.setBounds(755, 485, 97, 25);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.setBounds(864, 485, 97, 25);
		add(btnNewButton_3);
	}

}
