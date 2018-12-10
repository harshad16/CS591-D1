package src;

import java.util.*;
import java.sql.*;
import src.entities.*;
import src.service.ClassService;
import src.service.CourseService;
import src.service.StudentService;


public class Main {


    public static void main(String[] args) {

        CourseService cService = new CourseService();
        StudentService sService = new StudentService();
        ClassService classService = new ClassService();

        Course c1 = new Course("intro to programming", "the very first Course", "something", "something");
        Course c2 = new Course("intro to programming2", "the very first course2", null, null);
        Course c3 = new Course("course1", null, null, "tu-tr");
        Course c4 = new Course("course2", "about programming", "9:00-10:45 am", "mondays-wednesday");
        Course c5 = new Course("course3", "about memory models", "9:00-10:45 am", null);
        Course c6 = new Course("course4", "advanced course in javs", null, null);
        Course c7 = new Course("course4", null, "9:00-10:45 am", "mondays-wednesday");

        Student s1 = new Student("12345", "Arezoo", "sadeghi","fisrt-year", "graduate");
        Student s2 = new Student("12346", "Sepideh", "sadeghi","fisrt-year", "graduate");
        Student s3 = new Student("12347", "Delaram", "sadeghi","fisrt-year", "graduate");
        Student s4 = new Student("12348", "Maral", "Ghoshani","fisrt-year", "graduate");

        ClassEntity c1ass1 = new ClassEntity(2, 1);
        ClassEntity c1ass2 = new ClassEntity(2, 2);
        ClassEntity c1ass3 = new ClassEntity(3, 1);
        ClassEntity c1ass4 = new ClassEntity(3, 2);


        try {
            //cService.saveCourse(c1);
            //cService.saveCourse(c2);
            //cService.saveCourse(c3);
            //cService.saveCourse(c4);
            //cService.saveCourse(c5);
            //cService.saveCourse(c6);
            //cService.saveCourse(c7);

            /*sService.saveStudent(s1);
            sService.saveStudent(s2);
            sService.saveStudent(s3);
            sService.saveStudent(s4);*/

            /*classService.saveClass(c1ass1);
            classService.saveClass(c1ass2);
            classService.saveClass(c1ass3);
            classService.saveClass(c1ass4);*/

            //testing readCourses
            List<Course> courses = cService.readCourses("intro to programming");
            //List<Student> students = sService.readStudents("Maral");
            List<ClassEntity> classes = classService.readClasses(null);

            /*for (ClassEntity c: classes) {
                System.out.println(c);
            }*/

           System.out.println(courses.size());
            for (Course c: courses) {
                System.out.println(c);
            }

//            for (Student s: students) {
//                System.out.println(s);
//            }
            //testing delete courses
            //cService.deleteCourse(courses.get(0));
            //sService.deleteStudent(students.get(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
