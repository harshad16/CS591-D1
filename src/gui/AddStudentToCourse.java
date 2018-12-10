package src.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

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
                "Grade",
                "Add To Class"};
		Object[][] data = {
			    {"Kathy", "Smith",
			     "U123456789", new Integer(95), new Integer(93), "A", false},
			    {"John", "Doe",
			     "U87654321", new Integer(93), new Integer(93), "A", false}
			};
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 145, 905, 327);
		scrollPane.setHorizontalScrollBarPolicy(
				   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		
		DefaultTableModel tableModel=new DefaultTableModel(data, columnNames){
			// This Method is to make a column not be Editable on Table.
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return column == data[0].length ? false : true;  // Example: This is pointed to length; if want on any column point it to that.
		    }
		    
		    // This Method Renders Checkbox on Table.
		    @Override
		    public Class<?> getColumnClass(int columnIndex) {
	            return getValueAt(0, columnIndex).getClass();
	        }
		};
		JTable table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(400, 400));
		table.getTableHeader().setForeground(SystemColor.textHighlight);
		table.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 16));
		table.getTableHeader().setReorderingAllowed(false);
		Dimension d = table.getTableHeader().getPreferredSize();
		d.height = 30;
		table.getTableHeader().setSize(d);

		table.setFillsViewportHeight(true);
		table.setRowHeight(30);
		table.setFont(new Font("Georgia", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.setBounds(755, 485, 97, 25);
		add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub	
				for (int row = 0; row < table.getRowCount(); row++){
			        for ( int col=0; col < table.getColumnCount(); col++) {
			        	if ((table.getValueAt(row, table.getColumnCount()-1).toString()== "true")) {
			        		System.out.println(table.getValueAt(row, col));
			        	}
			        }
			    }
			}
		});
		
		
		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.setBounds(864, 485, 97, 25);
		add(btnNewButton_3);

	}
}
