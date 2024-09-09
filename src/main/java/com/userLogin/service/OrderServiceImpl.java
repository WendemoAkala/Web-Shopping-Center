package com.userLogin.service;

import com.userLogin.model.CustomUser;
import com.userLogin.model.Order;
import com.userLogin.model.OrderRequest;
import com.userLogin.model.OrderStatus;
import com.userLogin.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;
    @Override
    public void createOrder(OrderRequest orderRequest) throws Exception {
        Order existingOrder = orderRepository.findByUserId(orderRequest.getId());
        if(existingOrder != null){
            throw new Exception("User Id " + orderRequest.getId() + " is already exist change Id");
        }

            orderRepository.createOrder(orderRequest.toOrder());


    }

    @Override
    public void findOrderByUserId(Long userId) {
        orderRepository.findByUserId(userId);
    }

    @Override
    public void deleteOrder(Long userId) {
        Order existingOrder = orderRepository.findByUserId(userId);
        try{
           orderRepository.deleteById(userId);
         }catch (EnumConstantNotPresentException e){
          System.out.println("user not found");
         }
    }

    @Override
    public List<Order> findByUserAndStatusIn(CustomUser customUser, List<OrderStatus> temp) {
        return null;
    }

    @Override
    public Optional<Object> findById(Long orderId) {
        return Optional.empty();
    }

    @Override
    public Order save(Order order) {
        return save(order);
    }

    @Override
    public List<Order> findByUserId(Long userId) {
        return orderRepository.findOrderByUserId(userId);
    }

    @Override
    public Order updateOrderStatus(Long id, OrderStatus status) {
        return orderRepository.findByUserId(id);
    }
}
