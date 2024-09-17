package com.userLogin.service;

import com.userLogin.model.CustomUser;
import com.userLogin.model.Order;
import com.userLogin.model.OrderRequest;
import com.userLogin.model.OrderStatus;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void createOrder(OrderRequest orderRequest) throws Exception;

    void deleteOrder(Long userId);
    void findOrderByUserId(Long userId);
    List<Order> findByUserAndStatusIn(CustomUser customUser, List<OrderStatus> temp);

    List<Order> findOrdersByUserId(Long orderId);

    Order save(Order order);

    List<Order> findByUserId(Long userId);

    Order updateOrderStatus(Long id);

    Optional<Object> findById(Long orderId);
}
