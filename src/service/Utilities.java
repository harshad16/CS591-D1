package src.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

public class Utilities {
    public String driver = "com.mysql.cj.jdbc.Driver";
    public String db_name = "gradein";
    public String url = "jdbc:mysql://localhost/"+db_name+"?useSSL=false";
    public String user = "root";
    public String password = "password";

    public Connection getConnection()
            throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class.forName(driver).newInstance();
        Connection conn;
        try {
        	conn = DriverManager.getConnection(url, user, password);
        } catch (SQLSyntaxErrorException e) {
        	url = "jdbc:mysql://localhost/";
        	conn = DriverManager.getConnection(url, user, password);
		}
        
        conn.setAutoCommit(Boolean.FALSE);
        return conn;
    }
}
