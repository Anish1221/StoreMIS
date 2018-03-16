/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.storemis.dao.impl;

import com.example.storemis.dao.OrdersInfoDAO;
import com.example.storemis.dbutil.DbConnection;
import com.example.storemis.entity.OrdersInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class OrdersInfoDAOImpl implements OrdersInfoDAO {

    DbConnection db = new DbConnection();
    PreparedStatement stmt = null;
    OrdersInfo orderInfo = null;

    @Override
    public int insert(OrdersInfo t) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        db.open();
        String sql = "INSERT INTO orders_info(order_id, customer_id, product_id, order_qty, order_total) VALUES(?,?,?,?,?)";
        stmt = db.initStatement(sql);
        stmt.setInt(1, t.getOrderId());
        stmt.setInt(2, t.getCustomerId());
        stmt.setInt(3, t.getProductId());
        stmt.setInt(4, t.getOrderQty());
        stmt.setDouble(5, t.getTotal());
        int result = db.executeUpdate();
        db.close();

        return result;
    }

    @Override
    public List<OrdersInfo> getAll(int id) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        List<OrdersInfo> orderInfoList = new ArrayList();
        db.open();
        String sql = "SELECT * FROM orders_info WHERE order_id = ?";
        stmt = db.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = db.executeQuery();
        while (rs.next()) {
            orderInfo = new OrdersInfo();
            orderInfo.setOrderId(rs.getInt("order_id"));
            orderInfo.setCustomerId(rs.getInt("customer_id"));
            orderInfo.setProductId(rs.getInt("product_id"));
            orderInfo.setOrderQty(rs.getInt("order_qty"));
            orderInfo.setTotal(rs.getInt("order_total"));
            orderInfoList.add(orderInfo);
        }
        db.close();
        return orderInfoList;
    }

}
