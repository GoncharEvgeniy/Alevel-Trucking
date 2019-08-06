package com.alevel.trucking.controller;

import com.alevel.trucking.service.customer.CustomerService;
import com.alevel.trucking.service.driver.DriverService;
import com.alevel.trucking.service.manager.ManagerService;
import com.alevel.trucking.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/all-driver")
    ResponseEntity getAllDriver() {
        return ResponseEntity.ok(driverService.getAllDriver());
    }

    @PostMapping("/accept-order")
    ResponseEntity acceptOrder(){
        return null;
    }

}
