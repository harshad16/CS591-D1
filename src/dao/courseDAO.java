package src.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.entities.Course;
import src.service.StudentService;


public class courseDAO extends BaseDAO<Course>{

    public courseDAO(Connection conn) {
        super(conn);
    }

    public void saveCourse(Course c) throws SQLException {
        save("INSERT INTO course (name, description, start_time, days, college, courseid, type, userid) VALUES (?,?,?,?,?,?,?,?)", new Object[] { c.getName(), c.getDescription(), c.getStart_time(), c.getDays(), c.getCollege(), c.getCourseId(), c.getType(), c.getUserId()});
    }

    public Integer saveCourseID(Course c) throws SQLException {
        return saveWithID("INSERT INTO course (name, description, start_time, days, college, courseid, type, userid) VALUES (?,?,?,?,?,?,?,?)", new Object[] { c.getName(), c.getDescription(), c.getStart_time(), c.getDays(), c.getCollege(), c.getCourseId(), c.getType(), c.getUserId()});
    }

    public void updateCourse(Course c) throws SQLException {
        save("UPDATE course SET name = ? ,description = ?, start_time = ?, days = ?, college = ?, courseid = ? WHERE id = ?", new Object[] { c.getName(), c.getDescription(), c.getStart_time(), c.getDays(), c.getCollege(), c.getCourseId(), c.getId() });
    }

    public void updateCourseName(Course c) throws SQLException {
        save("UPDATE course SET name = ? WHERE id = ?", new Object[] { c.getName(), c.getId() });
    }

    public void updateCourseDescription(Course c) throws SQLException {
        save("UPDATE course SET description = ? WHERE id = ?", new Object[] { c.getDescription(), c.getId() });
    }

    public void deleteCourse(Course c) throws SQLException {
        save("DELETE FROM course WHERE id = ?", new Object[] { c.getId() });
    }

    public List<Course> readAllCourses() throws SQLException {
        return readAll("SELECT * FROM course", null);
    }

    public List<Course> readCoursesByName(String name) throws SQLException {
        name = "%" + name + "%";
        return readAll("SELECT * FROM course WHERE name like ?", new Object[] { name });
    }

    public List<Course> readCourses(String courseName) throws SQLException {
        if (courseName != null && !courseName.isEmpty()) {
            courseName = "%" + courseName + "%";
            return readAll("SELECT * FROM course WHERE name like ?", new Object[] { courseName });
        } else {
            return readAll("SELECT * FROM course", null);
        }

    }

    public List<Course> extractData(ResultSet rs) throws SQLException {

    	StudentDAO sdao = new StudentDAO(conn);
        AssignmentDAO adao = new AssignmentDAO(conn);
        List<Course> courses = new ArrayList<>();
        while (rs.next()) {
            Course c = new Course();
            c.setId(rs.getInt("id"));
            c.setCourseId(rs.getString("courseid"));
            c.setName(rs.getString("name"));
            c.setDescription(rs.getString("description"));
            c.setStart_time(rs.getString("start_time"));
            c.setStart_time(rs.getString("days"));
            c.setType(rs.getString("type"));
            c.setUserId(rs.getInt("userid"));
            c.setCollege(rs.getString("college"));
            c.setStudents(sdao.readAllFirstLevel("SELECT * FROM student WHERE id IN (SELECT studentid FROM class WHERE courseid = ?)",
                    new Object[] { c.getId() }));
            c.setAssignments(adao.readAllFirstLevel("SELECT * FROM assignment WHERE courseid = ?",
                    new Object[] { c.getId()}));
            courses.add(c);
        }
        return courses;

    }

    public List<Course> extractDataFirstLevel(ResultSet rs) throws SQLException {
        List<Course> courses = new ArrayList<>();
        while (rs.next()) {
            Course c = new Course();
            c.setId(rs.getInt(1));
            c.setName(rs.getString("name"));
            c.setDescription(rs.getString("description"));
            c.setCollege(rs.getString("college"));
            c.setCourseId(rs.getString("courseid"));
            c.setStart_time(rs.getString("start_time"));
            c.setDays(rs.getString("days"));
            c.setType(rs.getString("type"));
            c.setUserId(rs.getInt("userid"));
            courses.add(c);
        }
        return courses;
    }

}
