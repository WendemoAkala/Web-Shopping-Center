package com.userLogin.model;

import java.util.List;

public class OrderItem {
    private Long id;
    private Long userId;
    private Item items;
    private int quantity;
    public OrderItem(Long id, Long userId, Item items, int quantity) {
        this.id = id;
        this.userId = userId;
        this.items = items;
        this.quantity = quantity;
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

    public Item getItems() {
        return items;
    }

    public void setItems(Item itemId) {
        this.items= items;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
