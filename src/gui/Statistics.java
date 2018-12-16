package src.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.xy.XYDifferenceRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.function.Function2D;
import org.jfree.data.function.NormalDistributionFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;

import src.entities.Assignment;
import src.entities.Calculations;
import src.entities.Course;
import src.entities.Grade;
import src.service.AssignmentService;
import src.service.GradeService;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;

public class Statistics extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean general= false,curve=false;
	private Course course;
	private JLabel maxScoreText;
	private JLabel medianText;
	private JLabel stdDevText;
	private JLabel meanText;
	private JLabel minScoreText;
	private JComboBox<String> comboBox;
	private JLabel selectAssignmentOption;
	private Map<String, Integer> assgn;
	private String plotType;

	
	public Statistics(Course c) {
		this.course = c;
		setBounds(215, 146, 1021, 527);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(368, 90, 632, 400);
	    add(scrollPane);	    
	    
	    ButtonGroup buttonGroup = new ButtonGroup();
	    JButton generalButton = new JButton("General Statistics");
	    JButton curveButton = new JButton("Curve of Course");
	    
	    generalButton.setBounds(50, 52, 206, 25);
	    add(generalButton);
	    generalButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		general = true;
	    		curve = false;
	    		generalButton.setForeground(Color.BLUE);
	    		generalButton.setFont(new Font("Georgia", Font.BOLD, 14));
	    		curveButton.setForeground(Color.BLACK);
	    		curveButton.setFont(new Font("Georgia", Font.PLAIN, 14));
	    	}
	    });
	    buttonGroup.add(generalButton);

	    curveButton.setBounds(288, 52, 206, 25);
	    add(curveButton);
	    curveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				curve = true;
				general = false;
				curveButton.setForeground(Color.BLUE);
				curveButton.setFont(new Font("Georgia", Font.BOLD, 14));
	    		generalButton.setForeground(Color.BLACK);
	    		generalButton.setFont(new Font("Georgia", Font.PLAIN, 14));
	    		
	    		comboBox.setVisible(false);
	    		selectAssignmentOption.setVisible(false);
	    		
			}
	    });
	    buttonGroup.add(curveButton);
	    
	    JLabel statisticLabel = new JLabel("Statistics");
	    statisticLabel.setBounds(50, 12, 157, 31);
	    add(statisticLabel);
	    statisticLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		
	    JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBounds(50, 90, 306, 400);
	    add(scrollPane_1);
	    
	    JPanel panel = new JPanel();
	    scrollPane_1.setViewportView(panel);
	    panel.setLayout(null);
	    
	    ButtonGroup group = new ButtonGroup();
		
		JLabel degreeOption = new JLabel("Choose options:");
		degreeOption.setBounds(12, 12, 120, 16);
		panel.add(degreeOption);
		// Group of Radio Buttons for choice of Graduate, UnderGraduate and ALL
		JRadioButton graduateRadioButton = new JRadioButton("Graduate");
		graduateRadioButton.setBounds(12, 37, 120, 25);
		panel.add(graduateRadioButton);
		graduateRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Get Data of the graduate students
				if (curve == true && general == false) {
					ChartPanel cp = plotGraph("graduate");
					cp.setVisible(true);
					scrollPane.setViewportView(cp);
				}
				else {
					ChartPanel cp = plotBarGraph("graduate");
					plotType = "graduate";
					cp.setVisible(true);
					scrollPane.setViewportView(cp);
					comboBox.setVisible(true);
		    		selectAssignmentOption.setVisible(true);
				}	
			}
		});
		group.add(graduateRadioButton);

		JRadioButton undergraduateRadioButton = new JRadioButton("UnderGraduate");
		undergraduateRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		undergraduateRadioButton.setBounds(12, 67, 120, 25);
		panel.add(undergraduateRadioButton);
		undergraduateRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Get Data of the undergraduate students
				if (curve == true && general == false) {
					ChartPanel cp = plotGraph("undergraduate");
					cp.setVisible(true);
					scrollPane.setViewportView(cp);
				}
				else {
					ChartPanel cp = plotBarGraph("undergraduate");
					plotType = "undergraduate";
					cp.setVisible(true);
					scrollPane.setViewportView(cp);
					comboBox.setVisible(true);
		    		selectAssignmentOption.setVisible(true);
				}
			}
		});
		group.add(undergraduateRadioButton);

		JRadioButton allRadioButton = new JRadioButton("ALL");
		allRadioButton.setBounds(12, 94, 120, 25);
		panel.add(allRadioButton);
		allRadioButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// Get Data of the all students
				if (curve == true && general == false) {
					ChartPanel cp = plotGraph("both");
					cp.setVisible(true);
					scrollPane.setViewportView(cp);
				}
				else {
					ChartPanel cp = plotBarGraph("both");
					plotType = "both";
					cp.setVisible(true);
					scrollPane.setViewportView(cp);
					comboBox.setVisible(true);
		    		selectAssignmentOption.setVisible(true);
				}
			}
		});
		group.add(allRadioButton);
		
		
			
		selectAssignmentOption = new JLabel("Select the Assignment:");
		selectAssignmentOption.setBounds(12, 143, 183, 24);
		selectAssignmentOption.setVisible(false);
		panel.add(selectAssignmentOption);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(12, 174, 183, 22);
		comboBox.setVisible(false);
		try {
			assgn = populateAssignment();
			for(String val:assgn.keySet()){
				comboBox.addItem(val);;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					setStats(plotType,assgn.get(comboBox.getSelectedItem()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		});
		panel.add(comboBox);
		
		JLabel statsLabel = new JLabel("Stats:");
		statsLabel.setFont(new Font("Georgia", Font.BOLD, 14));
		statsLabel.setBounds(12, 218, 100, 20);
		panel.add(statsLabel);
		
		JLabel meanLabel = new JLabel("Mean");
		meanLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		meanLabel.setBounds(12, 245, 100, 20);
		panel.add(meanLabel);
		
		JLabel stdDevLabel = new JLabel("Std Dev");
		stdDevLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		stdDevLabel.setBounds(12, 275, 100, 20);
		panel.add(stdDevLabel);
		
		JLabel medianLabel = new JLabel("Median");
		medianLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		medianLabel.setBounds(12, 305, 100, 20);
		panel.add(medianLabel);
		
		JLabel maxScoreLabel = new JLabel("Highest Score");
		maxScoreLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		maxScoreLabel.setBounds(12, 335, 100, 20);
		panel.add(maxScoreLabel);
		
		JLabel minScoreLabel = new JLabel("Lowest Score");
		minScoreLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		minScoreLabel.setBounds(12, 365, 100, 20);
		panel.add(minScoreLabel);
		
		meanText = new JLabel();
		meanText.setText("mean");
		meanText.setBounds(160, 245, 100, 20);
		panel.add(meanText);
		
		stdDevText = new JLabel("std dev");
		stdDevText.setBounds(160, 275, 100, 20);
		panel.add(stdDevText);
		
		medianText = new JLabel("median");
		medianText.setBounds(160, 305, 100, 20);
		panel.add(medianText);
		
		maxScoreText = new JLabel("max");
		maxScoreText.setBounds(160, 335, 100, 20);
		panel.add(maxScoreText);
		
		minScoreText = new JLabel("min");
		minScoreText.setBounds(160, 365, 100, 20);
		panel.add(minScoreText);
		
	}
	
	public Map<String, Integer> populateAssignment() throws SQLException {
		AssignmentService aService = new AssignmentService();
		List<Assignment> assignment = aService.readAssignmentByCID(course.getId());
		Map<String, Integer> agnDict = new HashMap<String,Integer>();
		for (Assignment asgnE: assignment) {
			agnDict.put(asgnE.getName(),asgnE.getAssignmentId());
		}
		agnDict.put("OverAll",-1);
		return agnDict;
	}
	
	public void setStats(String plotType, Integer AssignmentId) throws SQLException {
		GradeService gService = new GradeService();
		List<Grade> grade = gService.readGrades();
		
		List<Double> score= new ArrayList<Double>();
		for(Grade grd:grade) {
			if(AssignmentId==grd.getAssignmentId()) {				
				if(plotType!=null && grd.getStudent().getType().toLowerCase().equals(plotType)) {
					score.add(grd.getGrade());
				}
				else if (plotType!=null && plotType.equals("both")) {
					score.add(grd.getGrade());
				}
			}
			else if(AssignmentId ==-1) {
				if(plotType!=null && grd.getStudent().getType().toLowerCase().equals(plotType)) {
					score.add(grd.getGrade());
				}
				else if (plotType!=null && plotType.equals("both")) {
					score.add(grd.getGrade());
				}
			}
		}
		Double[] assign_wise = score.toArray(new Double[score.size()]);
		if(score.size()>0) {
			Calculations cal = new Calculations(assign_wise);
			meanText.setText(((Number)cal.getMean()).toString());
			stdDevText.setText(((Number)cal.getStdDev()).toString());
			medianText.setText(((Number)cal.median()).toString());
			maxScoreText.setText(((Number)cal.getMax()).toString());
			minScoreText.setText(((Number)cal.getMin()).toString());
		}
	}
	
	public DefaultCategoryDataset getData(String plotType) throws SQLException {
		AssignmentService aService = new AssignmentService();
		GradeService gService = new GradeService();
		List<Assignment> assignment = aService.readAssignmentByCID(course.getId());
		List<Grade> grade = gService.readGrades();
		
		// Assignment wise Grades:
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (Assignment asgnE: assignment) {
			List<Double> score= new ArrayList<Double>();
			for(Grade grd:grade) {
				if(plotType!=null && grd.getStudent().getType().toLowerCase().equals(plotType)) {
					if(asgnE.getAssignmentId()==grd.getAssignmentId()) {
						score.add(grd.getGrade());
					}
				}
				else if (plotType!=null && plotType.equals("both")) {
					if(asgnE.getAssignmentId()==grd.getAssignmentId()) {
						score.add(grd.getGrade());
					}
				}
			}
			Double[] assign_wise = score.toArray(new Double[score.size()]);
			if(score.size()>0) {
				Calculations cal = new Calculations(assign_wise);
				dataset.addValue(cal.getMean(), "Mean", asgnE.getName());
				dataset.addValue(cal.getStdDev(), "StdDev", asgnE.getName());
				dataset.addValue(cal.median(), "Median", asgnE.getName());
				dataset.addValue(cal.getMax(), "Max Scored", asgnE.getName());
				dataset.addValue(cal.getMin(), "Min Scored", asgnE.getName());
			}
		}
		return dataset;
	}
	
	
	public Calculations getCurveData(String plotType) throws SQLException {
		AssignmentService aService = new AssignmentService();
		GradeService gService = new GradeService();
		List<Assignment> assignment = aService.readAssignmentByCID(course.getId());
		List<Grade> grade = gService.readGrades();
		
		// Assignment wise Grades:
		List<Double> totalscore = new ArrayList<Double>();
		for (Assignment asgnE: assignment) {
			for(Grade grd:grade) {
				if(plotType!=null && grd.getStudent().getType().toLowerCase().equals(plotType)) {
					if(asgnE.getAssignmentId()==grd.getAssignmentId()) {
						totalscore.add(grd.getGrade());
					}
				}
				else if (plotType!=null && plotType.equals("both")) {
					if(asgnE.getAssignmentId()==grd.getAssignmentId()) {
						totalscore.add(grd.getGrade());
					}
				}
			}
			if (totalscore.size()>0) {
				Double[] course_wise = totalscore.toArray(new Double[totalscore.size()]);
				Calculations cal = new Calculations(course_wise);
				return cal;
			}
		}
		return null ;
	}

	public ChartPanel plotGraph(String plotType) {
		
		Calculations curveCal=null;
		XYDataset dataset1=null;
		try {
			curveCal = getCurveData(plotType);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (curveCal!=null) {
			meanText.setText(((Number)curveCal.getMean()).toString());
			stdDevText.setText(((Number)curveCal.getStdDev()).toString());
			medianText.setText(((Number)curveCal.median()).toString());
			maxScoreText.setText(((Number)curveCal.getMax()).toString());
			minScoreText.setText(((Number)curveCal.getMin()).toString());
		    Function2D normal = new NormalDistributionFunction2D(curveCal.getMean(), curveCal.getStdDev());
		    dataset1 = DatasetUtilities.sampleFunction2D(normal, curveCal.getMin()-10, curveCal.getMax()+10, 100,"Normal"); 
		}
	    NumberAxis xAxis = new NumberAxis(null);
	    NumberAxis yAxis = new NumberAxis(null);
	    XYDifferenceRenderer renderer = new XYDifferenceRenderer();
		Plot plot = new XYPlot(dataset1, xAxis, yAxis, renderer);
	    
	    JFreeChart chart = new JFreeChart(plot);
	    chart.setTitle("Normal Distribution of course scores");

	    ChartPanel cp = new ChartPanel(chart);
	    cp.setPreferredSize(new Dimension(200, 100));
	    return cp;
	}
	
	public ChartPanel plotBarGraph(String plotType) {
		
		DefaultCategoryDataset dataset = null;
		try {
			dataset = getData(plotType);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JFreeChart chart = ChartFactory.createBarChart3D(
	            "Statistics",      // chart title
	            "Category",               // domain axis label
	            "Score",                  // range axis label
	            dataset,                  // data
	            PlotOrientation.VERTICAL, // orientation
	            true,                     // include legend
	            true,                     // tooltips
	            false                     // urls
	        );

        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
        );
        BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        ChartPanel cp = new ChartPanel(chart);
	    cp.setPreferredSize(new Dimension(200, 100));
	    return cp;
	}
}
