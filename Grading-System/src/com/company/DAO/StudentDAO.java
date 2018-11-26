package com.company.DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.entities.Student;

public class StudentDAO extends BaseDAO<Student>{

    public StudentDAO(Connection conn) {
        super(conn);
    }

    public void saveStudent(Student s) throws SQLException {
        save("INSERT INTO student (studentid, first_name, last_name, year, type) VALUES (?,?,?,?,?)", new Object[] { s.getStudentId(), s.getFirstName(), s.getLastName(), s.getYear(), s.getType()});
    }

    public Integer saveStudentID(Student s) throws SQLException {
        return saveWithID("INSERT INTO student (studentid, first_name, last_name, year, type) VALUES (?,?,?,?,?)", new Object[] { s.getStudentId(), s.getFirstName(), s.getLastName(), s.getYear(), s.getType()});
    }

    public void updateStudent(Student s) throws SQLException {
        save("UPDATE student SET studentid = ? ,first_name = ?, last_name = ?, year = ?, type = ? WHERE id = ?", new Object[] { s.getStudentId(), s.getFirstName(), s.getLastName(), s.getYear(), s.getType(), s.getId() });
    }

    public void updateStudentFirstName(Student s) throws SQLException {
        save("UPDATE student SET first_name = ? WHERE id = ?", new Object[] { s.getFirstName(), s.getId() });
    }

    public void updateStudentLastname(Student s) throws SQLException {
        save("UPDATE student SET last_name = ? WHERE id = ?", new Object[] { s.getLastName(), s.getId() });
    }

    public void deleteStudent(Student s) throws SQLException {
        save("DELETE FROM student WHERE id = ?", new Object[] { s.getId() });
    }

    public List<Student> readAllStudents() throws SQLException {
        return readAll("SELECT * FROM student", null);
    }

    public List<Student> readStudentsByName(String name) throws SQLException {
        name = "%" + name + "%";
        return readAll("SELECT * FROM student WHERE first_name like ?", new Object[] { name });
    }

    public List<Student> readStudents(String firstName) throws SQLException {
        if (firstName!= null && !firstName.isEmpty()) {
            firstName = "%" + firstName + "%";
            return readAll("SELECT * FROM student WHERE first_name like ?", new Object[] { firstName });
        } else {
            return readAll("SELECT * FROM student", null);
        }

    }

    //to do for later
    public List<Student> extractData(ResultSet rs) throws SQLException {

        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setFirstName(rs.getString("first_name"));
            s.setLastName(rs.getString("last_name"));
            s.setStudentId(rs.getString("studentid"));
            s.setYear(rs.getString("year"));
            s.setType(rs.getString("type"));
            students.add(s);

        }
        return students;

    }

    public List<Student> extractDataFirstLevel(ResultSet rs) throws SQLException {

        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setFirstName(rs.getString("first_name"));
            s.setLastName(rs.getString("last_name"));
            s.setStudentId(rs.getString("studentid"));
            s.setYear(rs.getString("year"));
            s.setType(rs.getString("type"));
            students.add(s);

        }
        return students;
    }

}
