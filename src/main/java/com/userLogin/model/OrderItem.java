package com.userLogin.model;

import java.util.List;

public class OrderItem {
    private Long id;
    private Long userId;
    private Item items;
    private int price;
    private int quantity;
    public OrderItem(Long id, Long userId, Item items, int price, int quantity) {
        this.id = id;
        this.userId = userId;
        this.items = items;
        this.price = price;
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

    public void setItemName(Item itemName) {
        this.items= items;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
