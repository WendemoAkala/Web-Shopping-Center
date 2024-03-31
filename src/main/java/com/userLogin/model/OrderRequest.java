package com.userLogin.model;

import java.util.Date;
import java.util.List;

public class OrderRequest {
    private Long id;
    private Long userId;
    private Date orderDate;
    private String shippingAddress;
    private Double totalPrice;
    private  OrderStatus status;

    public OrderRequest() {
    }

    public OrderRequest(Long id, Long userId, Date orderDate, String shippingAddress, Double totalPrice, OrderStatus status) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        this.status = status;
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

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Order toOrder(){
        return new Order(
                 null,
                this.userId,
                this.orderDate,
                this.shippingAddress,
                this.totalPrice,
                this.status
        );
    }
}
