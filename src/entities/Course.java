package src.entities;

import java.util.*;

public class Course {

    private Integer id;
    private String name;
    private String college;
    private String courseId;
    private String description;
    private String start_time;
    private String days;
    private String type;
    

    private List<Student> students;
    private List<Assignment> assignments;

    public Course(String name, String description, String start_time, String days, String courseid, String college, String type) {
        this.id = null;
        this.name = name;
        this.description =description;
        this.start_time = start_time;
        this.college = college;
        this.courseId = courseid;
        this.days = days;
        this.type = type;
        this.students = null;
        this.assignments = null;
        
    }
    
    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Course() {
        this.id = null;
        this.name = null;
        this.description = null;
        this.start_time = null;
        this.college = null;
        this.courseId = null;
        this.days = null;
        this.type  = null;
        this.students = null;
        this.assignments = null;
    }
    
    public String getCollege() {
    	return college;
    }
    
    public void setCollege(String college) {
    	this.college = college;
    }
    
    public String getCourseId() {
    	return courseId;
    }
    
    public void setCourseId(String courseId) {
    	this.courseId = courseId;
    }

    public Course(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    
    public String getType() {
    	return this.type;
    }
    
    public void setType(String type) {
    	this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }


    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }


    @Override
    public String toString() {

        String studentsToString = "";
        String assignmentsToString = "";
        
        for (Student s : this.students) {
            studentsToString += s + "#";
        }
        for (Assignment a: this.assignments) {
            assignmentsToString += a + "#";
        }
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start_time='" + start_time + '\'' +
                ", college='" + college + '\'' +
                ", courseId='" + courseId + '\'' +
                ", days='" + days + '\'' +
                ", type='" + type + '\'' +
                ", students='" + studentsToString + '\'' +
                 ", assignments='" + assignmentsToString + '\'' +
                '}';
    }
}
