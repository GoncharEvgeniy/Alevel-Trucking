package com.alevel.trucking.controller;

import com.alevel.trucking.dto.DriverRegistrationForm;
import com.alevel.trucking.dto.ManagerRegistrationForm;
import com.alevel.trucking.dto.UserDto;
import com.alevel.trucking.exception.UserEmailExistException;
import com.alevel.trucking.exception.UsernameExistException;
import com.alevel.trucking.model.person.driver.Driver;
import com.alevel.trucking.model.person.manager.Manager;
import com.alevel.trucking.service.admin.AdminService;
import com.alevel.trucking.service.customer.CustomerService;
import com.alevel.trucking.service.driver.DriverService;
import com.alevel.trucking.service.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final ManagerService managerService;

    private final DriverService driverService;

    private final CustomerService customerService;

    private final AdminService adminService;

    @Autowired
    public AdminController(ManagerService managerService,
                           DriverService driverService,
                           CustomerService customerService,
                           AdminService adminService) {
        this.managerService = managerService;
        this.driverService = driverService;
        this.customerService = customerService;
        this.adminService = adminService;
    }

    @GetMapping("/get-all-users")
    ResponseEntity getAllUsers() {
        List<UserDto> users = adminService.getAllUsers().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @PostMapping("/new-manager")
    ResponseEntity createNewManager(@RequestBody @Valid ManagerRegistrationForm managerRegistrationForm)
            throws UsernameExistException, UserEmailExistException {
        Manager manager = ManagerRegistrationForm.fromDto(managerRegistrationForm);
        return ResponseEntity.ok(managerService.save(manager));
    }

    @PostMapping("/new-driver")
    ResponseEntity createNewDriver(@RequestBody @Valid DriverRegistrationForm driverRegistrationForm)
            throws UsernameExistException, UserEmailExistException {
        Driver driver = DriverRegistrationForm.fromDto(driverRegistrationForm);
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
