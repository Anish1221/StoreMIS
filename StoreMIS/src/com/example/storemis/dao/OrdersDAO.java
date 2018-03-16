/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.storemis.dao;

import com.example.storemis.entity.Orders;

import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author acer
 */
public interface OrdersDAO extends GenericDAO<Orders> {

    int getLastId() throws ClassNotFoundException, SQLException;

    Date getDate(int id) throws ClassNotFoundException, SQLException;
}
