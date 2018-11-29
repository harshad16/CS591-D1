package com.company.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.entities.Credential;
import sun.security.krb5.Credentials;

public class CredentialDAO extends BaseDAO<Credential> {

    public CredentialDAO(Connection conn) {
        super(conn);
    }

    public void saveCredential(Credential c) throws SQLException {
        save("INSERT INTO security (password, security-question, security-question-answer) VALUES (?,?,?)", new Object[] { c.getPassword(), c.getSecurityQuestion(), c.getAnswerToSecurityQuestion()});
    }

    public Integer saveCredentialID(Credential c) throws SQLException {
        return saveWithID("INSERT INTO security (password, security-question, security-question-answer) VALUES (?,?,?)", new Object[] { c.getPassword(), c.getSecurityQuestion(), c.getAnswerToSecurityQuestion()});
    }

    public Integer updateCredential(Credential c) throws SQLException {
        return saveWithID("UPDATE security SET password = ?, security-question-answer = ?, WHERE id = ?", new Object[] { c.getPassword(), c.getAnswerToSecurityQuestion(), c.getId()});
    }

    public void updatePassword(Credential c) throws SQLException {
        save("UPDATE security SET password = ? WHERE id = ?", new Object[] { c.getPassword(), c.getId() });
    }

    public void updateSecurityAnswer(Credential c) throws SQLException {
        save("UPDATE security SET security-question-answer = ? WHERE id = ?", new Object[] { c.getAnswerToSecurityQuestion(), c.getId() });
    }

    public List<Credential> readAllCredentials() throws SQLException {
        return readAll("SELECT * FROM security", null);
    }



    public List<Credential> extractData(ResultSet rs) throws SQLException {

        List<Credential> credentials = new ArrayList<>();
        while (rs.next()) {
            Credential c = new Credential();
            c.setPassword(rs.getString("password"));
            c.setId(rs.getInt("id"));
            c.setAnswerToSecurityQuestion(rs.getString("security-question-answer"));
            credentials.add(c);
        }
        return credentials;

    }

    public List<Credential> extractDataFirstLevel(ResultSet rs) throws SQLException {
        List<Credential> credentials = new ArrayList<>();
        while (rs.next()) {
            Credential c = new Credential();
            c.setPassword(rs.getString("password"));
            c.setId(rs.getInt("id"));
            c.setAnswerToSecurityQuestion(rs.getString("security-question-answer"));
            credentials.add(c);
        }
        return credentials;
    }


}
