package com.userLogin.repository;

import com.userLogin.model.Order;
import com.userLogin.model.OrderStatus;
import com.userLogin.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private static final String ORDER_TABLE_NAME = "orders";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public void createOrder(Order order) {
        String sql = "INSERT INTO " + ORDER_TABLE_NAME + " (user_id, order_date, shipping_address, total_price, status) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getUserId(), order.getOrderDate(), order.getShippingAddress(), order.getTotalPrice(),
                order.getStatus().name());
    }



    @Override
    public List<Order> findByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Order> findOrderByStatus( OrderStatus status) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE status=?";
        try {
            return jdbcTemplate.query(sql,  orderMapper, status);
        } catch (EmptyResultDataAccessException error) {
            System.out.println("Empty Data Warning");
            return null;
        }
    }

    @Override
    public List<Order> findOrderByUserId(Long userId) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE user_id=?";
        try {
            return Collections.singletonList(jdbcTemplate.queryForObject(sql, new OrderMapper(), userId));
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public void deleteById(Long customUser) {

    }


}
