package src.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.entities.ClassEntity;
import src.entities.Course;


public class ClassDAO extends BaseDAO<ClassEntity>{

    public ClassDAO(Connection conn) {
        super(conn);
    }

    public void saveClass(ClassEntity c) throws SQLException {
        save("INSERT INTO class (courseid, studentid) VALUES (?,?)", new Object[] { c.getCourseId(), c.getStudentId()});
    }

    public Integer saveClassID(ClassEntity c) throws SQLException {
        return saveWithID("INSERT INTO class (courseid, studentid) VALUES (?,?)", new Object[] { c.getCourseId(), c.getStudentId()});
    }

    public void updateClass(ClassEntity c) throws SQLException {
        save("UPDATE class SET courseid = ?, studentid = ? WHERE id = ?", new Object[] { c.getCourseId(), c.getStudentId(), c.getClassId() });
    }

    public void deleteClass(ClassEntity c) throws SQLException {
        save("DELETE FROM class WHERE id = ?", new Object[] { c.getClassId() });
    }

    public List<ClassEntity> readAllClasses() throws SQLException {
        return readAll("SELECT * FROM class", null);
    }

    public List<ClassEntity> readCLasses(String searchString) throws SQLException {
        if (searchString!= null && !searchString.isEmpty()) {
            searchString = "%" + searchString + "%";
            return readAll("SELECT * FROM class WHERE courseName like ?", new Object[] { searchString });
        } else {
            return readAll("SELECT * FROM class", null);
        }

    }


    public List<ClassEntity> extractData(ResultSet rs) throws SQLException {

        StudentDAO sdao = new StudentDAO(conn);
        courseDAO cdao = new courseDAO(conn);
        List<ClassEntity> classes = new ArrayList<>();

        while (rs.next()) {
            ClassEntity c = new ClassEntity();
            c.setClassId(rs.getInt("id"));
            c.setCourseId(rs.getInt("courseid"));
            c.setStudentId(rs.getInt("studentid"));
            c.setStudents(sdao.readAllFirstLevel(
                    "SELECT * FROM student WHERE id IN (SELECT studentid FROM class WHERE courseid = ?)",
                    new Object[] { c.getCourseId() }));
            List<Course> courses = cdao.readAllFirstLevel(
                    "SELECT * FROM course WHERE id = ?",
                    new Object[] { c.getCourseId() });
            c.setCourse(courses.get(0));
            classes.add(c);

        }
        return classes;

    }

    public List<ClassEntity> extractDataFirstLevel(ResultSet rs) throws SQLException {

        List<ClassEntity> classes = new ArrayList<>();
        while (rs.next()) {
            ClassEntity c = new ClassEntity();
            c.setClassId(rs.getInt("id"));
            c.setCourseId(rs.getInt("courseid"));
            c.setStudentId(rs.getInt("studentid"));
            classes.add(c);

        }
        return classes;
    }

}
