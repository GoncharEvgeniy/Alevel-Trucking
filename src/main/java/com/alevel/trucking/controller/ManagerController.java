package com.alevel.trucking.controller;

import com.alevel.trucking.model.order.OrderStatus;
import com.alevel.trucking.service.customer.CustomerService;
import com.alevel.trucking.service.driver.DriverService;
import com.alevel.trucking.service.manager.ManagerService;
import com.alevel.trucking.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerService managerService;

    private final CustomerService customerService;

    private final DriverService driverService;

    private final OrderService orderService;

    @Autowired
    public ManagerController(ManagerService managerService, CustomerService customerService,
                             DriverService driverService, OrderService orderService) {
        this.managerService = managerService;
        this.customerService = customerService;
        this.driverService = driverService;
        this.orderService = orderService;
    }

    @GetMapping("/all-orders")
    ResponseEntity getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @GetMapping("/all-orders-by-customer/{id}")
    ResponseEntity getAllOrdersByCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderByCustomerId(id));
    }

    @GetMapping("/all-orders-by-driver")
    ResponseEntity getAllOrdersByDriver() {
        return null;
    }

    @GetMapping("/all-orders-by-status/{status}")
    ResponseEntity getAllOrdersByStatus(@PathVariable String status) {
        return ResponseEntity.ok(orderService.getAllOrdersByStatus(OrderStatus.valueOf(status)));
    }

    @GetMapping("/all-customer")
    ResponseEntity getAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/all-driver")
    ResponseEntity getAllDriver() {
        return ResponseEntity.ok(driverService.getAllDriver());
    }

    @PostMapping("/accept-order")
    ResponseEntity acceptOrder() {
        return null;
    }

}
