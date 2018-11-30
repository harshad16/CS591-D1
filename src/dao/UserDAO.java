package src.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.entities.User;

public class UserDAO extends BaseDAO<User>{

	public UserDAO(Connection conn) {
		super(conn);
	}
	
	public void saveUser(User u) throws SQLException {
        save("INSERT INTO user (username, password, securityQuestion, securityQuestionAnswer) VALUES (?,?,?,?)", new Object[] { u.getUserName(), u.getPassword(), u.getSecurityQuestion(), u.getSecurityQuestionAnswer()});
    }
	
	public Integer saveUserWithId(User u) throws SQLException {
		return saveWithID("INSERT INTO user (username, password, securityQuestion, securityQuestionAnswer) VALUES (?,?,?,?)",  new Object[] { u.getUserName(), u.getPassword(), u.getSecurityQuestion(), u.getSecurityQuestionAnswer()});
	}

    public void updateUser(User u) throws SQLException {
        save("UPDATE user SET password = ? WHERE id = ?", new Object[] { u.getPassword(), u.getId() });
    }

    public void deleteUser(User u) throws SQLException {
        save("DELETE FROM user WHERE id = ?", new Object[] { u.getId() });
    }
    
    public List<User> findUserByUserName(String search) throws SQLException{
    		return readAll("SELECT * FROM user WHERE username = ?", new Object[] { search });
    }

    public List<User> readAllUsers() throws SQLException {
        return readAll("SELECT * FROM user", null);
    }


	@Override
	public List<User> extractData(ResultSet rs) throws SQLException {
		List<User> users = new ArrayList<>();
		while(rs.next()) {
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setPassword(rs.getString("password"));
			u.setSecurityQuestion(rs.getString("securityQuestion"));
			u.setSecurityQuestionAnswer(rs.getString("securityQuestionAnswer"));
			users.add(u);
		}
		return users;
	}

	@Override
	public List<User> extractDataFirstLevel(ResultSet rs) throws SQLException {
		List<User> users = new ArrayList<>();
		while(rs.next()) {
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setPassword(rs.getString("password"));
			u.setSecurityQuestion(rs.getString("securityQuestion"));
			u.setSecurityQuestionAnswer(rs.getString("securityQuestionAnswer"));
			users.add(u);
		}
		return users;
	}
	
	

}
