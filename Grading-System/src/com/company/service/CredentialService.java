package com.company.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.company.DAO.CredentialDAO;
import com.company.entities.Credential;


public class CredentialService {
    public Utilities util;

    public CredentialService() {
        util = new Utilities();
    }

    public void saveCredential(Credential c) throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            CredentialDAO cdao = new CredentialDAO(conn);
            if(c.getId()!=null){
                cdao.updateCredential(c);
            }else{
                cdao.saveCredential(c);
            }
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


    public List<Credential> readCredential() throws SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            CredentialDAO cdao = new CredentialDAO(conn);
            return cdao.readAllCredentials();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally{
            if(conn!=null){
                conn.close();
            }
        }

        return null;
    }


}
