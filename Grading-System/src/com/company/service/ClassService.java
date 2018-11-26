package com.company.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.company.DAO.ClassDAO;
import com.company.entities.ClassEntity;


public class ClassService {

    public Utilities util;

    public ClassService() {
        util = new Utilities();
    }

    public void saveClass(ClassEntity c) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            ClassDAO cdao = new ClassDAO(conn);
            if(c.getClassId()!=null){
                cdao.updateClass(c);
            }else{
                cdao.saveClass(c);
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

    public void deleteClass(ClassEntity c) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            ClassDAO cdao = new ClassDAO(conn);
            cdao.deleteClass(c);
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

    public List<ClassEntity> readClasses(String searchString) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            ClassDAO cdao = new ClassDAO(conn);
            return cdao.readCLasses(null);
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
