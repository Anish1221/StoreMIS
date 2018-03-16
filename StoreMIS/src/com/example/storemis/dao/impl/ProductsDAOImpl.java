/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.storemis.dao.impl;

import com.example.storemis.dao.ProductsDAO;
import com.example.storemis.dbutil.DbConnection;
import com.example.storemis.entity.Products;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class ProductsDAOImpl implements ProductsDAO {

    DbConnection db = new DbConnection();
    PreparedStatement stmt = null;
    Products product = null;

    @Override
    public int insert(Products t) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        db.open();
        String sql = "INSERT INTO products(product_name, product_category, quantity, unit_price)"
                + "VALUES(?,?,?,?)";
        stmt = db.initStatement(sql);
        stmt.setString(1, t.getProductName());
        stmt.setString(2, t.getProductCategory());
        stmt.setInt(3, t.getQuantity());
        stmt.setDouble(4, t.getUnitPrice());

        int result = db.executeUpdate();

        db.close();
        return result;
    }

    @Override
    public int update(Products t) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        db.open();
        String sql = "UPDATE  products SET product_name=?, product_category=?, quantity=?, unit_price=? WHERE product_id=?";
        stmt = db.initStatement(sql);
        stmt.setString(1, t.getProductName());
        stmt.setString(2, t.getProductCategory());
        stmt.setInt(3, t.getQuantity());
        stmt.setDouble(4, t.getUnitPrice());
        stmt.setInt(5, t.getProductId());

        int result = db.executeUpdate();

        db.close();
        return result;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        db.open();
        String sql = "DELETE FROM products WHERE product_id=?";
        stmt = db.initStatement(sql);
        stmt.setInt(1, id);

        int result = db.executeUpdate();

        db.close();
        return result;
    }

    @Override
    public List<Products> getByName(String s) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Products> productList = new ArrayList<>();

        db.open();
        String sql = "SELECT * FROM products WHERE product_name = ?";
        stmt = db.initStatement(sql);
        stmt.setString(1, s);
        ResultSet rs = db.executeQuery();
        if (rs.next()) {
            product = new Products();
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductCategory(rs.getString("product_category"));
            product.setQuantity(rs.getInt("quantity"));
            product.setUnitPrice(rs.getDouble("unit_price"));
            productList.add(product);
        }
        db.close();
        return productList;
    }

    @Override
    public List<Products> getAll() throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        List<Products> productList = new ArrayList<>();
        db.open();
        String sql = "SELECT * FROM products";
        stmt = db.initStatement(sql);
        ResultSet rs = db.executeQuery();
        while (rs.next()) {
            product = new Products();
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductCategory(rs.getString("product_category"));
            product.setQuantity(rs.getInt("quantity"));
            product.setUnitPrice(rs.getDouble("unit_price"));
            productList.add(product);

        }
        db.close();
        return productList;
    }

    @Override
    public Products getById(int id) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        db.open();
        String sql = "SELECT * FROM products WHERE product_id = ?";
        stmt = db.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = db.executeQuery();
        if (rs.next()) {
            product = new Products();
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductCategory(rs.getString("product_category"));
            product.setQuantity(rs.getInt("quantity"));
            product.setUnitPrice(rs.getDouble("unit_price"));

        }
        db.close();
        return product;
    }

    @Override
    public int getId(String name) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        db.open();
        String sql = "SELECT product_id, product_name FROM products";
        stmt = db.initStatement(sql);
        ResultSet rs = db.executeQuery();
        while (rs.next()) {
            if (rs.getString("product_name").equalsIgnoreCase(name)) {
                return rs.getInt("product_id");
            }
        }
        db.close();
        return -1;
    }

    @Override
    public int deductQty(double qty, int id) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        db.open();
        String sql = "UPDATE products SET quantity=? WHERE product_id=? ";
        stmt = db.initStatement(sql);
        stmt.setDouble(1, qty);
        stmt.setInt(2, id);
        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public int getQty(int id) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        db.open();
        String sql = "SELECT quantity FROM products WHERE product_id=?";
        stmt = db.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = db.executeQuery();
        if (rs.next()) {
            return rs.getInt("quantity");
        }
        db.close();
        return -1;
    }

}
