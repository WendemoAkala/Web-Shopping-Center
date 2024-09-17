package com.userLogin.repository;

import com.userLogin.model.CustomUser;
import com.userLogin.model.Order;
import com.userLogin.model.OrderStatus;

import java.util.List;

public interface OrderRepository {
    void createOrder(Order order);
    Order findById(Long id);
    Order findByUserId(Long userId);
    List<Order> findOrdersByStatus( OrderStatus status);
    List<Order> findOrdersByUserId(Long userId);
    Order findOrderByUserId(Long userId);

    void deleteById(Long userId);
}
