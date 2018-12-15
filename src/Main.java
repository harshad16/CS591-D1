package src;

import java.sql.SQLException;

import src.gui.Index;

public class Main {

    public static void main(String[] args) {    	
    	System.out.println("Welcome to GradeIn");
    	
    	// Test the Back end connections
    	Test backendTest = new Test();
        try {
			backendTest.runTest();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    	// Start the GUI
        Index gui= new Index();
        gui.mainFrame.setVisible(true);
        
    }
}
