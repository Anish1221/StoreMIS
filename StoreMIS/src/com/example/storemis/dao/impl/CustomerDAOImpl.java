/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.storemis.dao.impl;

import com.example.storemis.dao.CustomerDAO;
import com.example.storemis.dbutil.DbConnection;
import com.example.storemis.entity.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class CustomerDAOImpl implements CustomerDAO {

    DbConnection db = new DbConnection();
    PreparedStatement stmt = null;
    Customer customer = null;

    @Override
    public int insert(Customer t) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        db.open();
        String sql = "INSERT INTO customer(first_name, last_name, customer_phno, customer_address)"
                + "VALUES(?,?,?,?)";
        stmt = db.initStatement(sql);
        stmt.setString(1, t.getFirstName());
        stmt.setString(2, t.getLastName());
        stmt.setString(3, t.getPhone());
        stmt.setString(4, t.getAddress());

        int result = db.executeUpdate();

        db.close();
        return result;
    }

    @Override
    public int update(Customer t) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = "UPDATE  customer SET first_name=?, last_name=?, customer_phno=?, customer_address=? WHERE customer_id=?";
        stmt = db.initStatement(sql);
        stmt.setString(1, t.getFirstName());
        stmt.setString(2, t.getLastName());
        stmt.setString(3, t.getPhone());
        stmt.setString(4, t.getAddress());
        stmt.setInt(5, t.getId());

        int result = db.executeUpdate();

        db.close();
        return result;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        db.open();
        String sql = "DELETE FROM customer WHERE customer_id=?";
        stmt = db.initStatement(sql);
        stmt.setInt(1, id);

        int result = db.executeUpdate();

        db.close();
        return result;
    }

    @Override
    public List<Customer> getAll() throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        List<Customer> customerList = new ArrayList<>();
        db.open();
        String sql = "SELECT * FROM customer";
        stmt = db.initStatement(sql);
        ResultSet rs = db.executeQuery();
        while (rs.next()) {
            customer = new Customer();
            customer.setId(rs.getInt("customer_id"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setPhone(rs.getString("customer_phno"));
            customer.setAddress(rs.getString("customer_address"));

            customerList.add(customer);

        }
        db.close();
        return customerList;
    }

    @Override
    public Customer getById(int id) throws ClassNotFoundException, SQLException {

        db.open();
        String sql = "SELECT * from customer WHERE customer_id=?";
        stmt = db.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = db.executeQuery();
        if (rs.next()) {
            customer = new Customer();
            customer.setId(rs.getInt("customer_id"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setPhone(rs.getString("customer_phno"));
            customer.setAddress(rs.getString("customer_address"));
        }

        return customer;
    }

    @Override
    public int getByName(String firstName, String lastName) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        db.open();
        String sql = "SELECT customer_id, first_name, last_name FROM customer";
        stmt = db.initStatement(sql);
        ResultSet rs = db.executeQuery();
        while (rs.next()) {
            if (rs.getString("first_name").equalsIgnoreCase(firstName) && rs.getString("last_name").equalsIgnoreCase(lastName)) {
                return rs.getInt("customer_id");
            }
        }
        db.close();
        return -1;

    }

    @Override
    public int getLastId() throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int lastId = 0;
        db.open();
        String sql = "SELECT MAX(customer_id) AS id FROM customer";
        stmt = db.initStatement(sql);
        ResultSet rs = db.executeQuery();

        if (rs.next()) {
            lastId = rs.getInt("id");
        }

        db.close();
        return lastId;
    }

}
