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

    public CustomUser getCustomUser() {
        return customUser;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public Order getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(Order userOrder) {
        this.userOrder = userOrder;
    }
}
