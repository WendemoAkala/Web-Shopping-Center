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
        return orderService.findByUserId(userId);
    }

    @GetMapping("/{userId}")
    @CrossOrigin
    public List<Order> getOrderDetails(@PathVariable Long userId) {
       return orderService.findByUserId(userId);
    }

    @PutMapping("/modify/{orderId}")
    @CrossOrigin
    public ResponseEntity<Order> modifyOrder(@PathVariable Long orderId, @RequestBody Order modifiedOrder) {
        Order existingOrder = (Order) orderService.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));

        if (existingOrder.getStatus().name().equals(modifiedOrder.getStatus().name())) {
          List<OrderItem> modifiedItems = (List<OrderItem>) existingOrder;

            for (OrderItem modifiedItem : modifiedItems) {
                Item item = modifiedItem();
                int quantityOrdered = modifiedItem.getQuantity();
                if (quantityOrdered <= item.getStockCount()) {
                    item.setStockCount(item.getStockCount() - quantityOrdered);
                    itemService.save(item);
                } else {
                    throw new RuntimeException("Insufficient stock for item: " + item.getTitle());
                }
            }
            orderService.save(existingOrder);
            return null;
        } else {
            throw new RuntimeException("Cannot modify a closed order");
        }
    }

    private Item modifiedItem() {
        return itemService.findItemByTitle(modifiedItem().getTitle());
    }

    @PostMapping("/create")
    @CrossOrigin
    public void createOrder(  @RequestBody OrderRequest orderRequest) throws Exception {
        orderService.createOrder(orderRequest);
    }

    @GetMapping("/history/{userId}")
    @CrossOrigin
    public List<Order> getOrderHistory(@PathVariable Long userId) {
        return orderService.findByUserId(userId);
    }

    @PutMapping("/updateStatus/{id}")
    @CrossOrigin
    public Order updateOrderStatus(@PathVariable Long id, @RequestParam OrderStatus status) {
            return orderService.updateOrderStatus(id, status);
    }
@PutMapping("/updateItem")     /*  לבדוק איך לעדכן כמות*/
@CrossOrigin
    private void updateItemStock(@RequestParam Long userId) {
         orderService.findOrderByUserId(userId);
}


    @DeleteMapping("/delete/{userId}")
    @CrossOrigin
    public void deleteOrder(@PathVariable Long userId) {
            orderService.deleteOrder(userId);
    }

}
