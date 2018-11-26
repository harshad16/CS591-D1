package com.company.entities;

import java.util.*;

public class Course {

    private Integer courseId;
    private String name;
    private String description;
    private String start_time;
    private String days;

    private List<Student> students;

    public Course(String name, String description, String start_time, String days) {
        this.courseId = null;
        this.name = name;
        this.description =description;
        this.start_time = start_time;
        this.days = days;
        this.students = null;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Course() {
        this.courseId = null;
        this.name = null;
        this.description = null;
        this.start_time = null;
        this.days = null;
        this.students = null;
    }

    public Course(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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
        for (Student s : this.students) {
            studentsToString += s + "#";
        }
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start_time='" + start_time + '\'' +
                ", days='" + days + '\'' +
                ", students='" + studentsToString + '\'' +
                '}';
    }
}
