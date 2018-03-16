/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.storemis.entity;

/**
 *
 * @author acer
 */
public class OrdersInfo {

    private int orderId;
    private int customerId;
    private int productId;
    private int orderQty;
    private double total;

    public OrdersInfo() {
    }

    public OrdersInfo(int orderId, int customerId, int productId, int orderQty, double total) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.orderQty = orderQty;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
