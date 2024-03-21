package com.userLogin.model;

import java.util.Date;
import java.util.List;

public class Order {
    private Long id;
    private Long userId;
    private Date orderDate;
    private String shippingAddress;
    private double totalPrice;
    private  OrderStatus status;



    public Order (Long id, Long userId, Date orderDate, String shippingAddress, double totalPrice, OrderStatus status) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        this.status = status;

    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public Object getDate() {
        return null;
    }

    public Object getTotalPrice() {
        return null;
    }

}
