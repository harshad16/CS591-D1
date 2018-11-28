package src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseDAO<T> {

    public static Connection conn = null;

    public BaseDAO(Connection conn) {
        BaseDAO.conn = conn;
    }

    public void save(String sql, Object[] vals) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        if (vals != null) {
            int count = 1;
            for (Object o : vals) {
                pstmt.setObject(count, o);
                count++;
            }
        }
        pstmt.executeUpdate();
    }

    public Integer saveWithID(String sql, Object[] vals) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        if (vals != null) {
            int count = 1;
            for (Object o : vals) {
                pstmt.setObject(count, o);
                count++;
            }
        }
        pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return null;
    }

    public List<T> readAll(String sql, Object[] vals) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        if (vals != null) {
            int count = 1;
            for (Object o : vals) {
                pstmt.setObject(count, o);
                count++;
            }
        }
        ResultSet rs = pstmt.executeQuery();
        return extractData(rs);
    }

    public abstract List<T> extractData(ResultSet rs) throws SQLException;

    public List<T> readAllFirstLevel(String sql, Object[] vals) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        if (vals != null) {
            int count = 1;
            for (Object o : vals) {
                pstmt.setObject(count, o);
                count++;
            }
        }
        ResultSet rs = pstmt.executeQuery();
        return extractDataFirstLevel(rs);

    }

    public abstract List<T> extractDataFirstLevel(ResultSet rs) throws SQLException;
}

