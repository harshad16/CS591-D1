package src.service;

import src.entities.*;
import src.dao.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import src.dao.AssignmentDAO;
import src.entities.Assignment;


public class AssignmentService {

	public Utilities util;

    public AssignmentService() {
        util = new Utilities();
    }

    public void saveAssignment(Assignment a) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            AssignmentDAO adao = new AssignmentDAO(conn);
            if(a.getAssignmentId()!=null){
                adao.updateAssignment(a);
            }else{
                adao.saveAssignment(a);
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

    public void deleteAssignment(Assignment a) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            AssignmentDAO adao = new AssignmentDAO(conn);
            adao.deleteAssignment(a);
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

    public List<Assignment> readAssignments(String searchString) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            AssignmentDAO adao = new AssignmentDAO(conn);
            return adao.readAssignments(searchString);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally{
            if(conn!=null){
                conn.close();
            }
        }

        return null;
    }
    
    public List<Assignment> readAssignmentByCID(Integer cid) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            AssignmentDAO adao = new AssignmentDAO(conn);
            return adao.readAssignmentByCID(cid);
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
