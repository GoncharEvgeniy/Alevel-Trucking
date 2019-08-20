package com.alevel.trucking.controller;

import com.alevel.trucking.dto.CustomerRegistrationForm;
import com.alevel.trucking.model.person.customer.Customer;
import com.alevel.trucking.model.user.User;
import com.alevel.trucking.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class MainController {

    private final CustomerService customerService;

    @Autowired
    public MainController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/reg")
    public ResponseEntity newUser(@RequestBody @Valid CustomerRegistrationForm customerDto) {
        Customer customer = CustomerRegistrationForm.fromDto(customerDto);
        return ResponseEntity.ok(customerService.save(customer));
    }

    @GetMapping()
    public ResponseEntity getMainPage() {
        User user = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        String visitor;
        if (user == null) {
            visitor = "guest";
        } else {
            visitor = user.getUsername();
        }
        return ResponseEntity.ok("Hello " + visitor + "!");
    }
}
