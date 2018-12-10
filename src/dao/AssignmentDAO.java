package src.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.entities.Assignment;


public class AssignmentDAO extends BaseDAO<Assignment>{

    public AssignmentDAO(Connection conn) {
        super(conn);
    }

    public void saveAssignment(Assignment a) throws SQLException {
        save("INSERT INTO assignment (courseid, name, weight, description) VALUES (?,?,?,?)", new Object[] { a.getCourseId(), a.getName(), a.getWeight(), a.getDescription()});
    }



    public Integer saveAssignmentID(Assignment a) throws SQLException {
        return saveWithID("INSERT INTO assignment (courseid, name, weight, description) VALUES (?,?,?,?)", new Object[] { a.getCourseId(), a.getName(), a.getWeight(), a.getDescription()});
    }

    public void updateAssignment(Assignment a) throws SQLException {
        save("UPDATE assignment SET courseid = ? ,name = ?, weight = ?, description = ? WHERE id = ?", new Object[] { a.getCourseId(), a.getName(), a.getWeight(), a.getDescription(), a.getAssignmentId() });
    }

    public void updateAssignmentName(Assignment a) throws SQLException {
        save("UPDATE assignment SET name = ? WHERE id = ?", new Object[] { a.getName(), a.getAssignmentId() });
    }

    public void updateAssignmentWeight(Assignment a) throws SQLException {
        save("UPDATE assignment SET weight = ? WHERE id = ?", new Object[] { a.getWeight(), a.getAssignmentId() });
    }

    public void deleteAssignment(Assignment a) throws SQLException {
        save("DELETE FROM assignment WHERE id = ?", new Object[] { a.getAssignmentId() });
    }

    public List<Assignment> readAllAssigments() throws SQLException {
        return readAll("SELECT * FROM assignment", null);
    }

    public List<Assignment> readAssignmentByName(String name) throws SQLException {
        name = "%" + name + "%";
        return readAll("SELECT * FROM assignment WHERE name like ?", new Object[] { name });
    }
    
    public List<Assignment> readAssignmentByCID(Integer cid) throws SQLException {
    	if (cid != null) {
    		return readAll("SELECT * FROM assignment WHERE courseid = ?", new Object[] { cid });
    	}
		return readAll("SELECT * FROM assignment", null);
    }

    public List<Assignment> readAssignments(String name) throws SQLException {
        if (name != null && !name.isEmpty()) {
            name = "%" + name + "%";
            return readAll("SELECT * FROM assignment WHERE name like ?", new Object[] { name });
        } else {
            return readAll("SELECT * FROM assignment", null);
        }

    }

    public List<Assignment> extractData(ResultSet rs) throws SQLException {

        StudentDAO sdao = new StudentDAO(conn);
        List<Assignment> assignments = new ArrayList<>();
        while (rs.next()) {
            Assignment a = new Assignment();
            a.setAssignmentId(rs.getInt("id"));
            a.setName(rs.getString("name"));
            a.setDescription(rs.getString("description"));
            a.setCourseId(rs.getInt("courseid"));
            a.setWeight(rs.getInt("weight"));
            assignments.add(a);
        }
        return assignments;

    }

    public List<Assignment> extractDataFirstLevel(ResultSet rs) throws SQLException {
        StudentDAO sdao = new StudentDAO(conn);
        List<Assignment> assignments = new ArrayList<>();
        while (rs.next()) {
            Assignment a = new Assignment();
            a.setAssignmentId(rs.getInt("id"));
            a.setName(rs.getString("name"));
            a.setDescription(rs.getString("description"));
            a.setCourseId(rs.getInt("courseid"));
            a.setWeight(rs.getInt("weight"));
            assignments.add(a);
        }
        return assignments;

    }
}
