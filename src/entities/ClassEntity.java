package src.entities;

import java.util.*;

public class ClassEntity {

    private Integer classId;
    private Integer courseId;
    private Integer studentId;

    private List<Student> students;
    private Course course;

    public ClassEntity(Integer courseId, Integer studentId) {

        this.classId = null;
        this.courseId = courseId;
        this.studentId = studentId;
        this.students = null;
        this.course = null;
    }

    @Override
    public String toString() {

        String studentToString = "";
        for (Student s: this.students) {
          studentToString += s;
        }
        return "ClassEntity{" +
                "classId=" + classId +
                ", courseId=" + courseId +
                ", studentId=" + studentId +
                ", students="  + studentToString +
                ", course=" + course +
                '}';
    }

    public ClassEntity() {

        this.classId = null;
        this.courseId = null;
        this.studentId = null;
        this.students = null;
        this.course = null;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getClassId() {

        return classId;
    }

    public void setClassId(Integer classId) {

        this.classId = classId;
    }

    public Integer getCourseId() {

        return courseId;
    }


    public void setCourseId(Integer courseId) {

        this.courseId = courseId;
    }

    public Integer getStudentId() {

        return studentId;
    }

    public void setStudentId(Integer studentId) {

        this.studentId = studentId;
    }


}