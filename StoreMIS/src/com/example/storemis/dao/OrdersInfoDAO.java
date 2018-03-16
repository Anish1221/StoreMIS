/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.storemis.dao;

import com.example.storemis.entity.OrdersInfo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author acer
 */
public interface OrdersInfoDAO {

    int insert(OrdersInfo t) throws ClassNotFoundException, SQLException;

    List<OrdersInfo> getAll(int id) throws ClassNotFoundException, SQLException;

}
