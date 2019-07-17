package com.alevel.trucking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/all-my-orders")
    ResponseEntity getAllOrders() {
        return null;
    }

    @GetMapping("/my-orders-in-process")
    ResponseEntity getOrdersInProcess() {
        return null;
    }

    @PostMapping("/new-order")
    ResponseEntity newOrder() {
        return null;
    }
}
