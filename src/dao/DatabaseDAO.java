package src.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import src.entities.Database;

public class DatabaseDAO extends BaseDAO<Object> {

	public DatabaseDAO(Connection conn) {
		super(conn);
	}
	
	public void checkTables(Database db) {
		try {
			createDatabase(db.createSchema());
			createDatabase(db.enableUniqueCheck());
			createDatabase(db.enableForeignCheck());
			createDatabase(db.enableSqlMode());
			createDatabase(db.createUser());
			createDatabase(db.createCourse());
			createDatabase(db.createClass());
			createDatabase(db.createStudent());
			createDatabase(db.createAssignment());
			createDatabase(db.createGrade());
			createDatabase(db.unableSqlMode());
			createDatabase(db.unableForeignCheck());
			createDatabase(db.unableUniqueCheck());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Object> extractData(ResultSet rs) throws SQLException {
		return null;
	}

	@Override
	public List<Object> extractDataFirstLevel(ResultSet rs) throws SQLException {
		return null;
	}

}
