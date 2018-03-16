/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.storemis.dao.impl;

import com.example.storemis.dao.AdminDAO;
import com.example.storemis.dbutil.DbConnection;
import com.example.storemis.entity.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public class AdminDAOImpl implements AdminDAO {

    DbConnection db = new DbConnection();
    PreparedStatement stmt = null;

    @Override
    public boolean validate_login(String username, String password) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean bool = false;
        db.open();
        String sql = "Select * from admin where username=? and password=?";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = db.executeQuery();
        if (rs.next()) {
            bool = true;
        }
        db.close();
        return bool;
    }

    @Override
    public int insert(Admin a) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        db.open();

        String sql = "INSERT INTO admin(username, password)"
                + "VALUES(?,?)";
        PreparedStatement stmt = db.initStatement(sql);

        stmt.setString(1, a.getUsername());
        stmt.setString(2, a.getPassword());

        int result = db.executeUpdate();

        db.close();

        return result;
    }

}
