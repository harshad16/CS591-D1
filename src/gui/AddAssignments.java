package src.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AddAssignments extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	public AddAssignments() {
		setBounds(215, 146, 1021, 527);
		setLayout(null);
		
		String[] columnNames = {"Assignment",
                "Weightage",
                "Total"};
		Object[][] data = {
			    {"Project", new Integer(15), new Integer(100),true},
			    {"Final", new Integer(85), new Integer(100),false},
			    {"","","",false}
			};
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 32, 960, 422);
		scrollPane.setHorizontalScrollBarPolicy(
				   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		DefaultTableModel tableModel=new DefaultTableModel(data, columnNames){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return row == data.length-1 ? true : false;
		    }
		    
		};
		table = new JTable(tableModel);
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
		
		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.setBounds(864, 485, 97, 25);
		add(btnNewButton_3);
		
	}
	
}
