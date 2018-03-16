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
public class Orders {

    private int orderId;
    private int orderCustomerId;

    public Orders() {
    }

    public Orders(int orderId, int orderCustomerId) {
        this.orderId = orderId;
        this.orderCustomerId = orderCustomerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderCustomerId() {
        return orderCustomerId;
    }

    public void setOrderCustomerId(int orderCustomerId) {
        this.orderCustomerId = orderCustomerId;
    }

}
