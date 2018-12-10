package src;

import src.gui.Index;

public class Main {

    public static void main(String[] args) {    	
    	System.out.println("Welcome to GradeIn");
    	
    	// Test the Back end connections
    	Test backendTest = new Test();
        backendTest.runTest();
        
    	// Start the GUI
        Index gui= new Index();
        gui.mainFrame.setVisible(true);
        
    }
}
