package com.userLogin.model;

import java.util.List;

public class UserOrderResponse {
    private CustomUser customUser;
    private List<Order> userOrderList;

    public UserOrderResponse() {
    }

    public UserOrderResponse(CustomUser customUser, List<Order> userOrderList) {
        this.customUser = customUser;
        this.userOrderList = userOrderList;
    }
    public UserOrderResponse toUserOrderResponse(
            CustomUser customUser,
            List<Order> userOrderList ){

       return new UserOrderResponse (
                customUser,
                userOrderList
                );
    }

    private void userOrderResponse(CustomUser customUser, List<Order> userOrderList) {
    }
}
