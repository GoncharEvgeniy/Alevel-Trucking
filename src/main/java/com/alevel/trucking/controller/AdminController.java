package com.alevel.trucking.controller;

import com.alevel.trucking.dto.DriverRegistrationForm;
import com.alevel.trucking.dto.ManagerRegistrationForm;
import com.alevel.trucking.dto.UsersBuilder;
import com.alevel.trucking.model.person.driver.Driver;
import com.alevel.trucking.model.person.manager.Manager;
import com.alevel.trucking.service.customer.CustomerService;
import com.alevel.trucking.service.driver.DriverService;
import com.alevel.trucking.service.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final ManagerService managerService;

    private final DriverService driverService;

    private final CustomerService customerService;

    @Autowired
    public AdminController(ManagerService managerService,
                           DriverService driverService,
                           CustomerService customerService) {
        this.managerService = managerService;
        this.driverService = driverService;
        this.customerService = customerService;
    }

    @PostMapping("/new-manager")
    ResponseEntity createNewManager(@RequestBody @Valid ManagerRegistrationForm managerRegistrationForm) {
        Manager manager = UsersBuilder.fromDto(managerRegistrationForm);
        return ResponseEntity.ok(managerService.save(manager));
    }

    @PostMapping("/new-driver")
    ResponseEntity createNewDriver(@RequestBody @Valid DriverRegistrationForm driverRegistrationForm) {
        Driver driver = UsersBuilder.fromDto(driverRegistrationForm);
        return ResponseEntity.ok(driverService.save(driver));
    }

    @DeleteMapping("/delete-manager/{id}")
    ResponseEntity deleteManager(@PathVariable Long id) {
        return ResponseEntity.ok(managerService.deleteManager(id));
    }

    @DeleteMapping("/delete-driver/{id}")
    ResponseEntity deleteDriver(@PathVariable Long id) {
        return ResponseEntity.ok(driverService.deleteDriver(id));
    }

    @DeleteMapping("/delete-customer/{id}")
    ResponseEntity deleteCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }
}
