package src.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import src.dao.StudentDAO;
import src.entities.Student;


public class StudentService {
    public Utilities util;

    public StudentService() {
        util = new Utilities();
    }

    public void saveStudent(Student s) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            StudentDAO sdao = new StudentDAO(conn);
            if(s.getId()!=null){
                sdao.updateStudent(s);
            }else{
                sdao.saveStudent(s);
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

    public void deleteStudent(Student s) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            StudentDAO sdao = new StudentDAO(conn);
            sdao.deleteStudent(s);
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

    public List<Student> findStudentByLastName(String lastName) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            StudentDAO sdao = new StudentDAO(conn);
            return sdao.findStudentByLastName(lastName);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally{
            if(conn!=null){
                conn.close();
            }
        }

        return null;
    }
    
    public List<Student> findStudentById(Integer id) throws SQLException{
    		Connection conn = null;
    		try {
    			conn = util.getConnection();
    			StudentDAO sdao = new StudentDAO(conn);
    			return sdao.findStudentById(id);
    		}catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
    			 e.printStackTrace();
    		}finally{
                if(conn!=null){
                    conn.close();
                }
    		}
    		return null;
    }
    
    
    public List<Student> findStudentByBUId(String id) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			StudentDAO sdao = new StudentDAO(conn);
			return sdao.findStudentByBUId(id);
		}catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
		}finally{
            if(conn!=null){
                conn.close();
            }
		}
		return null;
    }
    
    public List<Student> findStudentByFirstName(String firstName) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			StudentDAO sdao = new StudentDAO(conn);
			return sdao.findStudentByFirstName(firstName);
		}catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
		}finally{
            if(conn!=null){
                conn.close();
            }
		}
		return null;
}

}
