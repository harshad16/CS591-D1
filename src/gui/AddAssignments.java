package src.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AddAssignments extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public AddAssignments() {
		setBounds(215, 146, 1021, 527);
		setLayout(null);
		
		String[] columnNames = {"Assignment",
                "Weightage",
                "Total"};
		Object[][] data = {
			    {"Project", new Integer(15), new Integer(100)},
			    {"Final", new Integer(85), new Integer(100)}
			};
		
		
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.setBounds(755, 485, 97, 25);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.setBounds(864, 485, 97, 25);
		add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 32, 960, 422);
		add(scrollPane);
		
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
	}
}
