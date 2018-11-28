package src.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import src.dao.courseDAO;
import src.entities.Course;

public class CourseService {

    public Utilities util;

    public CourseService() {
        util = new Utilities();
    }

    public void saveCourse(Course c) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            courseDAO cdao = new courseDAO(conn);
            if(c.getCourseId()!=null){
                cdao.updateCourse(c);
            }else{
                cdao.saveCourse(c);
            }
            conn.commit();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally{
            if(conn!=null){
                conn.close();
            }
        }
    }

    public void deleteCourse(Course c) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            courseDAO cdao = new courseDAO(conn);
            cdao.deleteCourse(c);
            conn.commit();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally{
            if(conn!=null){
                conn.close();
            }
        }
    }

    public List<Course> readCourses(String searchString) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            courseDAO cdao = new courseDAO(conn);
            return cdao.readCourses(searchString);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally{
            if(conn!=null){
                conn.close();
            }
        }

        return null;
    }

}
