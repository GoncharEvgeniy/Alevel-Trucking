package com.alevel.trucking.controller;

import com.alevel.trucking.dto.CustomerRegistrationForm;
import com.alevel.trucking.dto.UsersBuilder;
import com.alevel.trucking.model.person.customer.Customer;
import com.alevel.trucking.service.customer.CustomerService;
import com.alevel.trucking.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity newUser(@RequestBody CustomerRegistrationForm customerDto) {
        Customer customer = UsersBuilder.fromDto(customerDto);
        return ResponseEntity.ok(customerService.save(customer));
    }

    //TODO only for test
    @GetMapping()
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }
}
