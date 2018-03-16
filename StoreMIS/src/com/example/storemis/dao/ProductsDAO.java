/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.storemis.dao;

import com.example.storemis.entity.Products;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author acer
 */
public interface ProductsDAO extends GenericDAO<Products> {

    List<Products> getByName(String s) throws ClassNotFoundException, SQLException;

    int getId(String name) throws ClassNotFoundException, SQLException;

    int getQty(int id) throws ClassNotFoundException, SQLException;

    int deductQty(double qty, int id) throws ClassNotFoundException, SQLException;
}
