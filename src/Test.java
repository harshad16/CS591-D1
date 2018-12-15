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

	public void runTest() {
		
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
		
		// For Testing Purpose only
		CourseService cService = new CourseService();
        StudentService sService = new StudentService();
        ClassService classService = new ClassService();

        Course c1 = new Course("Object oriented Design Using Java", "First Course", "9:00-11:45:", "Mon,Tues,Thrus", "CS591-D1", "CAS", "", 1, "Fall-2018");
        Student s1 = new Student("U12345678", "Foo", "Bar","fall-2018", "graduate");
        ClassEntity c1ass1 = new ClassEntity(1, 1);

        try {
        	List<Course> x = cService.readMostRecentCourse();
            if (x.get(0).getId()==null) {
	        	cService.saveCourse(c1);
	            sService.saveStudent(s1);
	            classService.saveClass(c1ass1);
            }
        } catch (SQLException e) {;}
	}
}
