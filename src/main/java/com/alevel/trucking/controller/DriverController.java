package com.alevel.trucking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/driver")
public class DriverController {

    @GetMapping("/all-orders")
    ResponseEntity getAllOrders() {
        return null;
    }

    @GetMapping("/order-in-process")
    ResponseEntity getOrder() {
        return null;
    }
}
