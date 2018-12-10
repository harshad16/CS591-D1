package src.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import src.dao.GradeDAO;
import src.entities.Grade;

public class GradeService {
    public Utilities util;

    public GradeService() {
        util = new Utilities();
    }

    public void saveGrade(Grade g) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            GradeDAO gdao = new GradeDAO(conn);
            if(g.getId()!=null){
                gdao.updateGrade(g);
            }else{
                gdao.saveGrade(g);
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

    public void deleteGrade(Grade g) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            GradeDAO gdao = new GradeDAO(conn);
            gdao.deleteGrade(g);;
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

    public List<Grade> readGrades() throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            GradeDAO gdao = new GradeDAO(conn);
            return gdao.readAllGrades();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally{
            if(conn!=null){
                conn.close();
            }
        }

        return null;
    }
    
    public List<Grade> readGradesByStudentId(Integer studentId) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            GradeDAO gdao = new GradeDAO(conn);
            return gdao.readGradesByStudentId(studentId);
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
