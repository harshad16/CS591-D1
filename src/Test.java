package src;

import java.sql.SQLException;
import java.util.List;
import src.entities.ClassEntity;
import src.entities.Course;
import src.entities.Database;
import src.entities.Student;
import src.service.ClassService;
import src.service.CourseService;
import src.service.DatabaseSetup;
import src.service.StudentService;
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
