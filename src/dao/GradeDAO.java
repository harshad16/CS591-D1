package src.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.entities.Grade;
import src.entities.Student;
import src.entities.Assignment;


public class GradeDAO extends BaseDAO<Grade>{

    public GradeDAO(Connection conn) {
        super(conn);
    }

    public void saveGrade(Grade grade) throws SQLException {
        save("INSERT INTO grade (assignmentid, studentid, note, grade) VALUES (?,?,?,?)", new Object[] { grade.getAssignmentId(), grade.getStudentId(), grade.getNote(), grade.getGrade()});
    }

    public Integer saveGradeID(Grade g) throws SQLException {
        return saveWithID("INSERT INTO grade (assignmentid, studentid, note, grade) VALUES (?,?,?,?)", new Object[] { g.getAssignmentId(), g.getStudentId(), g.getNote(), g.getGrade()});
    }

    public void updateGrade(Grade g) throws SQLException {
        save("UPDATE grade SET assignmentid = ? ,studentid = ?, note = ?, grade = ? WHERE id = ?", new Object[] { g.getAssignmentId(), g.getStudentId(), g.getNote(), g.getGrade(), g.getId() });
    }

    public void updateMark(Grade g) throws SQLException {
        save("UPDATE grade SET grade = ? WHERE id = ?", new Object[] { g.getGrade(), g.getId() });
    }

    public void updateNote(Grade g) throws SQLException {
        save("UPDATE grade SET note = ? WHERE id = ?", new Object[] { g.getNote(), g.getId() });
    }

    public void deleteGrade(Grade g) throws SQLException {
        save("DELETE FROM grade WHERE id = ?", new Object[] { g.getId() });
    }

    public List<Grade> readAllGrades() throws SQLException {
        return readAll("SELECT * FROM grade", null);
    }

    public List<Grade> readGradesByAssignmentId(Integer assignmentId) throws SQLException {
        return readAll("SELECT * FROM grade WHERE assignmentid = ?", new Object[] { assignmentId });
    }

    public List<Grade> readGradesByStudentId(Integer studentId) throws SQLException {
        return readAll("SELECT * FROM grade WHERE studentid = ?", new Object[] { studentId });
    }

    public List<Grade> extractData(ResultSet rs) throws SQLException {

        AssignmentDAO adao = new AssignmentDAO(conn);
        StudentDAO sdao = new StudentDAO(conn);
        List<Grade> grades = new ArrayList<>();
        while (rs.next()) {
            Grade g = new Grade();
            g.setId(rs.getInt("id"));
            g.setAssignmentId(rs.getInt("assignmentid"));
            g.setStudentId(rs.getInt("studentid"));
            g.setNote(rs.getString("note"));
            g.setGrade(rs.getDouble("grade"));
            List<Student> studentsList = sdao.readAllFirstLevel("SELECT * FROM student WHERE id = ?",
                    new Object[] { g.getStudentId() });
            g.setStudent(studentsList.get(0));
            List<Assignment> assignmentsList = adao.readAllFirstLevel("SELECT * FROM assignment WHERE id = ?", new Object[] { g.getAssignmentId()});
            g.setAssignment(assignmentsList.get(0));
            grades.add(g);
        }
        return grades;

    }

    public List<Grade> extractDataFirstLevel(ResultSet rs) throws SQLException {
        List<Grade> grades = new ArrayList<>();
        while (rs.next()) {
            Grade g = new Grade();
            g.setId(rs.getInt("id"));
            g.setAssignmentId(rs.getInt("assignmentid"));
            g.setStudentId(rs.getInt("studentid"));
            g.setNote(rs.getString("note"));
            g.setGrade(rs.getDouble("grade"));
            grades.add(g);
        }
        return grades;
    }


}
