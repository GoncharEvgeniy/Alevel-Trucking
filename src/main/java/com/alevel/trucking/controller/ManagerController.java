package com.alevel.trucking.controller;

import com.alevel.trucking.dto.TransportDto;
import com.alevel.trucking.model.order.OrderStatus;
import com.alevel.trucking.service.customer.CustomerService;
import com.alevel.trucking.service.driver.DriverService;
import com.alevel.trucking.service.manager.ManagerService;
import com.alevel.trucking.service.order.OrderService;
import com.alevel.trucking.service.transport.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerService managerService;

    private final CustomerService customerService;

    private final DriverService driverService;

    private final OrderService orderService;

    private final TransportService transportService;

    @Autowired
    public ManagerController(ManagerService managerService,
                             CustomerService customerService,
                             DriverService driverService,
                             OrderService orderService,
                             TransportService transportService) {
        this.managerService = managerService;
        this.customerService = customerService;
        this.driverService = driverService;
        this.orderService = orderService;
        this.transportService = transportService;
    }

    @GetMapping("/all-orders")
    ResponseEntity getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @GetMapping("/all-orders-by-customer/{customerId}")
    ResponseEntity getAllOrdersByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderService.getOrdersByCustomerId(customerId));
    }

    @GetMapping("/all-orders-by-driver/{driverId}")
    ResponseEntity getAllOrdersByDriver(@PathVariable Long driverId) {
        return ResponseEntity.ok(driverService.getOrdersByDriver(driverId));
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

    @PostMapping("/new-transport")
    ResponseEntity addNewTransport(@RequestBody TransportDto transportDto) {
        return ResponseEntity.ok(transportService.save(TransportDto.fromDto(transportDto)));
    }

    @PostMapping("/accept-order")
    ResponseEntity acceptOrder(@RequestBody Long orderId,
                               @RequestBody List<Long> transportsId,
                               @RequestBody List<Long> driversId) {
        return ResponseEntity.ok(managerService.acceptOrder(orderId, transportsId, driversId));
    }

    @GetMapping("/get-valid-transport-for-order/{orderId}")
    ResponseEntity getValidTransportForOrder(@RequestParam Long orderId) {
        return ResponseEntity.ok(transportService.getValidTransportsForOrder(orderId));
    }

    @GetMapping("/get-free-driver")
    ResponseEntity getFreeDrivers(){
        return ResponseEntity.ok(driverService.getFreeDrivers());
    }

}
