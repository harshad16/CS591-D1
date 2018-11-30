package src.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import src.dao.UserDAO;
import src.entities.User;

public class UserService {
	Utilities util;
	
	public UserService() {
		util = new Utilities();
	}
	
	public void saveUser(User u) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserDAO udao = new UserDAO(conn);
			if(u.getId() != null) {
				udao.updateUser(u);
			}
			else udao.saveUser(u);
			conn.commit();
		}catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
	          conn.rollback();
		}finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public void deleteUser(User u) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserDAO udao = new UserDAO(conn);
			udao.deleteUser(u);
			conn.commit();
		}catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
	        conn.rollback();
		}finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public List<User> findUserByUserName(String search) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserDAO udao = new UserDAO(conn);
			return udao.findUserByUserName(search);
		}catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
	        conn.rollback();
		}finally {
			if(conn != null) {
				conn.close();
			}
		}
		return null;
	}
	
	public List<User> readAllUser() throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserDAO udao = new UserDAO(conn);
			return udao.readAllUsers();
		}catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
	        conn.rollback();
		}finally {
			if(conn != null) {
				conn.close();
			}
		}
		return null;
	}

}
