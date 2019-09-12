package com.alevel.trucking.controller;

import com.alevel.trucking.dto.OrderForm;
import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(orderService.getAllOrdersByCurrentCustomer());
    }

    @GetMapping("/my-orders-by-status/{status}")
    ResponseEntity getOrdersByStatus(@PathVariable String status) {
        return ResponseEntity.ok(orderService.getOrdersByCurrentCustomerAndStatus(status));
    }

    @PostMapping("/new-order")
    ResponseEntity newOrder(@RequestBody OrderForm orderForm) {
        Order order = OrderForm.fromDto(orderForm);
        return ResponseEntity.ok(orderService.saveNewOrder(order));
    }
}
