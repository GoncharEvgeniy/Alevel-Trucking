package com.alevel.trucking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/manager")
public class ManagerController {

    @GetMapping("/all-orders")
    ResponseEntity getAllOrders() {
        return null;
    }

    @GetMapping("/all-orders-by-customer")
    ResponseEntity getAllOrdersByCustomer() {
        return null;
    }

    @GetMapping("/all-orders-by-driver")
    ResponseEntity getAllOrdersByDriver() {
        return null;
    }

    @GetMapping("/all-orders-by-status")
    ResponseEntity getAllOrdersByStatus() {
        return null;
    }

    @GetMapping("/all-customer")
    ResponseEntity getAllCustomer() {
        return null;
    }

    @GetMapping("/all-driver")
    ResponseEntity getAllDriver() {
        return null;
    }

    @PostMapping("/new-order")
    ResponseEntity creatOrder(){
        return null;
    }
}
