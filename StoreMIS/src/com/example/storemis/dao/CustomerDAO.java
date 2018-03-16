/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.storemis.dao;

import com.example.storemis.entity.Customer;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public interface CustomerDAO extends GenericDAO<Customer> {

    int getByName(String firstName, String lastName) throws ClassNotFoundException, SQLException;

    int getLastId() throws ClassNotFoundException, SQLException;
}
