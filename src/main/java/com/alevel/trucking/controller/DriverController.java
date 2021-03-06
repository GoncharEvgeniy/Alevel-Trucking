package com.alevel.trucking.controller;

import com.alevel.trucking.model.order.OrderStatus;
import com.alevel.trucking.service.driver.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/all-my-orders")
    ResponseEntity getAllOrders() {
        return ResponseEntity.ok(driverService.getOrdersByCurrentDriver());
    }

    @GetMapping("/my-order-in-process")
    ResponseEntity getOrder() {
        return ResponseEntity.ok(driverService.getOrdersByCurrentDriverAndByStatus(OrderStatus.ON_WAY));
    }

    @GetMapping("/my-accepted-order")
    ResponseEntity getAcceptedOrder() {
        return ResponseEntity.ok(driverService.getOrdersByCurrentDriverAndByStatus(OrderStatus.ACCEPTED));
    }

    @PatchMapping("/start-doing-order/{orderId}")
    ResponseEntity startOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(driverService.startOrder(orderId));
    }

    @PatchMapping("/finish-doing-order/{orderId}")
    ResponseEntity finishOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(driverService.finishOrder(orderId));
    }

    @PatchMapping("/back-to-box")
    ResponseEntity backToBox() {
        return ResponseEntity.ok(driverService.backToBox()); // Todo not done
    }
}
