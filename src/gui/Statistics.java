package src.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.CategoryAxis;
//import org.jfree.chart.axis.CategoryLabelPositions;
//import org.jfree.chart.axis.NumberAxis;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PiePlot;
//import org.jfree.chart.plot.Plot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.chart.renderer.category.BarRenderer3D;
//import org.jfree.chart.renderer.xy.XYDifferenceRenderer;
//import org.jfree.data.category.CategoryDataset;
//import org.jfree.data.function.Function2D;
//import org.jfree.data.function.NormalDistributionFunction2D;
//import org.jfree.data.general.DatasetUtilities;
//import org.jfree.data.general.DefaultPieDataset;
//import org.jfree.data.xy.XYDataset;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Statistics extends JPanel {

	private boolean general= false,curve=false;
	/**
	 * Create the panel.
	 */
	public Statistics() {
		
//		setBounds(215, 146, 1021, 527);
//		setLayout(null);
//		
//		JScrollPane scrollPane = new JScrollPane();
//	    scrollPane.setBounds(368, 90, 632, 400);
//	    add(scrollPane);	    
//		
//	    JScrollPane scrollPane_1 = new JScrollPane();
//	    scrollPane_1.setBounds(50, 90, 306, 400);
//	    add(scrollPane_1);
//	    
//	    JPanel panel = new JPanel();
//	    scrollPane_1.setViewportView(panel);
//	    panel.setLayout(null);
//	    
//	    ButtonGroup buttonGroup = new ButtonGroup();
//	    JButton generalButton = new JButton("General Statistics");
//	    JButton curveButton = new JButton("Curve of Course");
//	    JButton pieButton = new JButton("Statistics on Assigments");
//	    
//	    generalButton.addActionListener(new ActionListener() {
//	    	public void actionPerformed(ActionEvent arg0) {
//	    		general = true;
//	    		curve = false;
//	    		generalButton.setForeground(Color.BLUE);
//	    		generalButton.setFont(new Font("Georgia", Font.BOLD, 14));
//	    		curveButton.setForeground(Color.BLACK);
//	    		curveButton.setFont(new Font("Georgia", Font.PLAIN, 14));
//	    	}
//	    });
//	    generalButton.setBounds(12, 23, 206, 25);
//	    panel.add(generalButton);
//	    buttonGroup.add(generalButton);
//	    
//	    curveButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				curve = true;
//				general = false;
//				curveButton.setForeground(Color.BLUE);
//				curveButton.setFont(new Font("Georgia", Font.BOLD, 14));
//	    		generalButton.setForeground(Color.BLACK);
//	    		generalButton.setFont(new Font("Georgia", Font.PLAIN, 14));
//			}
//	    });
//	    curveButton.setBounds(12, 60, 206, 25);
//	    panel.add(curveButton);
//	    buttonGroup.add(curveButton);
//		
//	
//	    
//		pieButton.setBounds(12, 98, 206, 25);
//		panel.add(pieButton);
//	    
//		
//		ButtonGroup group = new ButtonGroup();
//		
//		// Group of Radio Buttons for choice of Graduate, UnderGraduate and ALL
//		JRadioButton graduateRadioButton = new JRadioButton("Graduate");
//		graduateRadioButton.setBounds(12, 148, 120, 25);
//		panel.add(graduateRadioButton);
//		graduateRadioButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO: Get Data of the graduate students
//			}
//		});
//		group.add(graduateRadioButton);
//	    		
//	    		
//		JRadioButton undergraduateRadioButton = new JRadioButton("UnderGraduate");
//		undergraduateRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
//		undergraduateRadioButton.setBounds(12, 178, 120, 25);
//		panel.add(undergraduateRadioButton);
//		undergraduateRadioButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO: Get Data of the undergraduate students
//			}
//		});
//		group.add(undergraduateRadioButton);
//	    		
//	    		
//		JRadioButton allRadioButton = new JRadioButton("Both");
//		allRadioButton.setBounds(12, 205, 120, 25);
//		panel.add(allRadioButton);
//		allRadioButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO: Get Data of the all students
//				if (curve == true && general == false) {
//					System.out.println("All Has been Selected for Curve");
//					ChartPanel cp = plotGraph();
//					cp.setVisible(true);
//					scrollPane.setViewportView(cp);
//				}
//				else {
//					System.out.println("All Has been Selected for Bar");
//					ChartPanel cp = plotBarGraph();
//					cp.setVisible(true);
//					scrollPane.setViewportView(cp);
//				}
//			}
//		});
//		group.add(allRadioButton);
//		
//		JLabel lblNewLabel = new JLabel("Mean");
//		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
//		lblNewLabel.setBounds(12, 273, 56, 16);
//		panel.add(lblNewLabel);
//		
//		JLabel lblNewLabel_1 = new JLabel("Std Dev");
//		lblNewLabel_1.setBounds(12, 302, 56, 16);
//		panel.add(lblNewLabel_1);
//		
//		JLabel lblNewLabel_2 = new JLabel("Median");
//		lblNewLabel_2.setBounds(12, 331, 56, 16);
//		panel.add(lblNewLabel_2);
//		
//		JLabel lblNewLabel_3 = new JLabel("Highest Score");
//		lblNewLabel_3.setBounds(12, 360, 79, 25);
//		panel.add(lblNewLabel_3);
//		
//		JLabel lblNewLabel_4 = new JLabel("New label");
//		lblNewLabel_4.setBounds(80, 273, 56, 16);
//		panel.add(lblNewLabel_4);
//		
//		JLabel lblNewLabel_5 = new JLabel("New label");
//		lblNewLabel_5.setBounds(80, 302, 56, 16);
//		panel.add(lblNewLabel_5);
//		
//		JLabel lblNewLabel_6 = new JLabel("New label");
//		lblNewLabel_6.setBounds(80, 331, 56, 16);
//		panel.add(lblNewLabel_6);
//		
//		JLabel lblNewLabel_7 = new JLabel("New label");
//		lblNewLabel_7.setBounds(103, 364, 56, 16);
//		panel.add(lblNewLabel_7);
//	    
	    
	}
	
//	public ChartPanel plotGraph() {
//
//	    Function2D normal = new NormalDistributionFunction2D(50.0, 1.0);
//	    XYDataset dataset = DatasetUtilities.sampleFunction2D(normal, 0, 100, 100,"Normal"); 
//
//	    NumberAxis xAxis = new NumberAxis(null);
//	    NumberAxis yAxis = new NumberAxis(null);
//	    XYDifferenceRenderer renderer = new XYDifferenceRenderer();
//	    Plot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
//	    
//	    JFreeChart chart = new JFreeChart(plot);
//	    chart.setTitle("Normal Distribution of course scores");
//
//	    ChartPanel cp = new ChartPanel(chart);
//	    cp.setPreferredSize(new Dimension(200, 100));
//	    return cp;
//	}
//	
//	public ChartPanel plotBarGraph() {
//		
//		double[][] data = new double[][]
//	            {{10.0, 4.0, 15.0, 14.0},
//	             {-5.0, -7.0, 14.0, -3.0},
//	             {6.0, 17.0, -12.0, 7.0},
//	             {7.0, 15.0, 11.0, 0.0},
//	             {-8.0, -6.0, 10.0, -9.0},
//	             {9.0, 8.0, 0.0, 6.0},
//	             {-10.0, 9.0, 7.0, 7.0},
//	             {11.0, 13.0, 9.0, 9.0},
//	             {-3.0, 7.0, 11.0, -10.0}};
//	             
//		CategoryDataset dataset = DatasetUtilities.createCategoryDataset("Series ", "Category ", data);
//		JFreeChart chart = ChartFactory.createBarChart3D(
//	            "3D Bar Chart Demo",      // chart title
//	            "Category",               // domain axis label
//	            "Value",                  // range axis label
//	            dataset,                  // data
//	            PlotOrientation.VERTICAL, // orientation
//	            true,                     // include legend
//	            true,                     // tooltips
//	            false                     // urls
//	        );
//
//        CategoryPlot plot = chart.getCategoryPlot();
//        CategoryAxis axis = plot.getDomainAxis();
//        axis.setCategoryLabelPositions(
//            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
//        );
//        BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
//        renderer.setDrawBarOutline(false);
//        
//        ChartPanel cp = new ChartPanel(chart);
//	    cp.setPreferredSize(new Dimension(200, 100));
//	    return cp;
//	}
//	
//	public ChartPanel plotPieChart() {
//		DefaultPieDataset dataset = new DefaultPieDataset();
//        dataset.setValue("One", new Double(43.2));
//        dataset.setValue("Two", new Double(10.0));
//        dataset.setValue("Three", new Double(27.5));
//        dataset.setValue("Four", new Double(17.5));
//        dataset.setValue("Five", new Double(11.0));
//        dataset.setValue("Six", new Double(19.4));
//        
//        JFreeChart chart = ChartFactory.createPieChart(
//                "Pie Chart Demo 6",  // chart title
//                dataset,             // data
//                false,               // include legend
//                true,
//                false
//            );
//
//        PiePlot plot = (PiePlot) chart.getPlot();
//        ChartPanel cp = new ChartPanel(chart);
//	    cp.setPreferredSize(new Dimension(200, 100));
//	    return cp;
//	}
}
