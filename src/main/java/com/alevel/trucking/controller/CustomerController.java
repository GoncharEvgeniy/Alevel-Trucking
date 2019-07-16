package com.alevel.trucking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/customer")
public class CustomerController {

    @GetMapping("/all-my-orders")
    ResponseEntity getAllOrders() {
        return null;
    }

    @GetMapping("/orders-in-process")
    ResponseEntity getOrdersInProcess() {
        return null;
    }

    @PostMapping("/new-order")
    ResponseEntity newOrder() {
        return null;
    }
}
