package src.service;

import java.sql.Connection;
import java.sql.SQLException;

import src.dao.DatabaseDAO;
import src.entities.Database;

public class DatabaseSetup {
    public Utilities util;

    public DatabaseSetup() {
        util = new Utilities();
    }
    
    public void checkTables(Database db) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            DatabaseDAO cdao = new DatabaseDAO(conn);
            cdao.checkTables(db);
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
}
