package com.userLogin.model;

public class UserOrderRequest {
    private CustomUser customUser;
    private Order userOrder;

    public UserOrderRequest() {
    }
    public UserOrderRequest(CustomUser customUser, Order userOrder) {
        this.customUser = customUser;
        this.userOrder = userOrder;
    }
}
