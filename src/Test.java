package src;

import java.sql.SQLException;

import src.entities.Database;
import src.service.DatabaseSetup;
import src.service.Utilities;

public class Test {

	public void runTest() throws SQLException {
		
		System.out.println("Test Cases");
		DatabaseSetup dbService = new DatabaseSetup();
	    Utilities util = new Utilities();
	    System.out.println("Using Mysql Database: "+util.db_name);
		Database db = new Database(util.db_name);
		try {
			dbService.checkTables(db);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
