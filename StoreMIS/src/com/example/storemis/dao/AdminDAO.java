/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.storemis.dao;

import com.example.storemis.entity.Admin;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public interface AdminDAO {

    boolean validate_login(String username, String password) throws ClassNotFoundException, SQLException;

    int insert(Admin a) throws ClassNotFoundException, SQLException;
}
