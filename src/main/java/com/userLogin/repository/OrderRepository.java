package com.userLogin.repository;

import com.userLogin.model.Order;
import com.userLogin.model.OrderStatus;

import java.util.List;

public interface OrderRepository {
    void createOrder(Order order);
    Order findByUserId(Long userId);
    List<Order> findOrdersByStatus( OrderStatus status);
    List<Order> findOrderByUserId(Long userId);
    void deleteById(Long id);
}
