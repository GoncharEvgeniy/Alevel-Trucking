package com.alevel.trucking.controller;

import com.alevel.trucking.dto.RegistrationForm;
import com.alevel.trucking.model.person.customer.Customer;
import com.alevel.trucking.service.customer.CustomerService;
import com.alevel.trucking.service.user.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {

    private final UserService userService;

    private final CustomerService customerService;

    @Autowired
    public MainController(UserService userService, CustomerService customerService) {
        this.userService = userService;
        this.customerService = customerService;
    }

    @PostMapping("/reg")
    public ResponseEntity newUser(@RequestBody RegistrationForm customerDto) {
        Customer customer = RegistrationForm.fromDto(customerDto);
        return ResponseEntity.ok(customerService.save(customer));
    }

    //TODO only for test
    @GetMapping()
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }
}