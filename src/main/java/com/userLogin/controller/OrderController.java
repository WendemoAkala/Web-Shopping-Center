package com.userLogin.controller;

import com.userLogin.model.*;
import com.userLogin.service.ItemService;
import com.userLogin.service.OrderService;
import com.userLogin.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/public/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    @GetMapping("/user/{userId}")
    @CrossOrigin
    public List<Order> getUserOrders(@PathVariable Long userId) {
        CustomUser customUser = (CustomUser) userService.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        return orderService.findByUserAndStatusIn(customUser,List.of(OrderStatus.TEMP, OrderStatus.CLOSE));
    }

    @GetMapping("/{orderId}")
    @CrossOrigin
    public Order getOrderDetails(@PathVariable Long orderId) {
        return (Order) orderService.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @PutMapping("/modify/{orderId}")
    @CrossOrigin
    public Order modifyOrder(@PathVariable Long orderId, @RequestBody Order modifiedOrder) {
        Order existingOrder = (Order) orderService.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));

        if (existingOrder.getStatus().name().equals(OrderStatus.TEMP)) {
          List<OrderItem> modifiedItems = (List<OrderItem>) existingOrder;

            for (OrderItem modifiedItem : modifiedItems) {
                Item item = modifiedItem.getItems();
                int quantityOrdered = modifiedItem.getQuantity();
                if (quantityOrdered <= item.getStockCount()) {
                    item.setStockCount(item.getStockCount() - quantityOrdered);
                    itemService.save(item);
                } else {
                    throw new RuntimeException("Insufficient stock for item: " + item.getTitle());
                }
            }
            return orderService.save(existingOrder);
        } else {
            throw new RuntimeException("Cannot modify a closed order");
        }
    }
    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<?> createOrder(  @RequestBody OrderRequest orderRequest) {
                try{
        orderService.createOrder(orderRequest);
        return null;
    } catch (Exception exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    }

    @GetMapping("/history/{userId}")
    @CrossOrigin
    public List<Order> getOrderHistory(@PathVariable Long userId) {
        CustomUser customUser = (CustomUser) orderService.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return orderService.findByUserId(userId);
    }

    @PutMapping("/updateStatus/{orderId}")
    @CrossOrigin
    public Order updateOrderStatus(@PathVariable Long id, @RequestParam OrderStatus status) {
        Order order = (Order) orderService.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

        if (order.getStatus() == OrderStatus.TEMP) {
            order.setStatus(status);
            return orderService.save(order);
        } else {
            throw new RuntimeException("Cannot update status for a closed order");
        }
    }
@PostMapping("/updateItem")
@CrossOrigin
    private void updateItemStock(List<OrderItem> orderItems) {
    for (OrderItem orderItem : orderItems) {
        Item item = orderItem.getItems();
        int quantityOrdered = orderItem.getQuantity();

        if (quantityOrdered <= item.getStockCount()) {
            item.setStockCount(item.getStockCount() - quantityOrdered);
            itemService.save(item);
        } else {
            throw new RuntimeException("Insufficient stock for item: " + item.getTitle());
        }
    }
}


    @DeleteMapping("/delete/{userId}")
    @CrossOrigin
    public ResponseEntity<String> deleteOrder(@PathVariable Long userId) {
        try {
            orderService.deleteOrder(userId);
            return ResponseEntity.ok("Order deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting order");
        }
    }

}
