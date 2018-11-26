package com.company.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utilities {
    public String driver = "com.mysql.cj.jdbc.Driver";
    public String url = "jdbc:mysql://localhost/grading_system?useSSL=false";
    public String user = "root";
    public String password = "password";

    public Connection getConnection()
            throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url, user, password);
        conn.setAutoCommit(Boolean.FALSE);
        return conn;
    }
}
