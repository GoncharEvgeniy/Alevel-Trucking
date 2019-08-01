package com.alevel.trucking.controller;

import com.alevel.trucking.dto.OrderForm;
import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final OrderService orderService;

    @Autowired
    public CustomerController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all-my-orders")
    ResponseEntity getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrdersByCustomer());
    }

    @GetMapping("/my-orders-in-process")
    ResponseEntity getOrdersInProcess() {
        return null;
    }

    @PostMapping("/new-order")
    ResponseEntity newOrder(@RequestBody OrderForm orderForm) {
        Order order = OrderForm.fromDto(orderForm);
        orderService.save(order);
        return null;
    }
}
