package com.alevel.trucking.controller;

import com.alevel.trucking.dto.OrderForm;
import com.alevel.trucking.error.exception.CustomerNotFoundException;
import com.alevel.trucking.error.exception.OrderNotFoundException;
import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final OrderService orderService;

    @Autowired
    public CustomerController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all-my-orders")
    ResponseEntity getAllOrders() throws CustomerNotFoundException {
        return ResponseEntity.ok(orderService.getAllOrdersByCurrentCustomer());
    }

    @GetMapping("/my-orders-by-status/{status}")
    ResponseEntity getOrdersByStatus(@PathVariable String status)
            throws CustomerNotFoundException, OrderNotFoundException {
        return ResponseEntity.ok(orderService.getOrdersByCurrentCustomerAndStatus(status));
    }

    @PostMapping("/new-order")
    ResponseEntity newOrder(@RequestBody @Valid OrderForm orderForm) throws CustomerNotFoundException {
        Order order = OrderForm.fromDto(orderForm);
        return ResponseEntity.ok(orderService.saveNewOrder(order));
    }
}
