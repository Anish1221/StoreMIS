/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.storemis.dao.impl;

import com.example.storemis.dao.OrdersDAO;
import com.example.storemis.dbutil.DbConnection;
import com.example.storemis.entity.Orders;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author acer
 */
public class OrdersDAOImpl implements OrdersDAO {
    
    DbConnection db = new DbConnection();
    PreparedStatement stmt = null;
    Orders order = null;
    
    @Override
    public int insert(Orders t) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        db.open();
        String sql = "INSERT INTO orders(order_id, order_customer_id) VALUES(?,?)";
        stmt = db.initStatement(sql);
        stmt.setInt(1, t.getOrderId());
        stmt.setInt(2, t.getOrderCustomerId());
        int result = db.executeUpdate();
        db.close();
        
        return result;
    }
    
    @Override
    public int update(Orders t) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Orders getById(int id) throws ClassNotFoundException, SQLException {
        
        db.open();
        String sql = "SELECT order_customer_id FROM orders WHERE order_id = ?";
        stmt = db.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = db.executeQuery();
        while (rs.next()) {
            order = new Orders();
            order.setOrderCustomerId(rs.getInt("order_customer_id"));
        }
        db.close();
        return order;
    }
    
    @Override
    public List<Orders> getAll() throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Orders> orderList = new ArrayList<>();
        db.open();
        String sql = "SELECT * FROM orders ORDER BY order_date DESC";
        stmt = db.initStatement(sql);
        ResultSet rs = db.executeQuery();
        while (rs.next()) {
            order = new Orders();
            order.setOrderId(rs.getInt("order_id"));
            order.setOrderCustomerId(rs.getInt("order_customer_id"));
            
            orderList.add(order);
            
        }
        db.close();
        return orderList;
    }
    
    @Override
    public int getLastId() throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int lastId = 0;
        db.open();
        String sql = "SELECT MAX(order_id) AS id FROM orders";
        stmt = db.initStatement(sql);
        ResultSet rs = db.executeQuery();
        
        if (rs.next()) {
            lastId = rs.getInt("id");
        }
        
        db.close();
        return lastId;
    }
    
    @Override
    public Date getDate(int id) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Date date = null;
        db.open();
        String sql = "SELECT order_date FROM orders WHERE order_id = ?";
        stmt = db.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = db.executeQuery();
        if (rs.next()) {
            
            date = rs.getDate("order_date");
        }
        db.close();
        return date;
    }
    
}
