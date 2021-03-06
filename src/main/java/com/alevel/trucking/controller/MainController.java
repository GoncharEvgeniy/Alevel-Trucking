package com.alevel.trucking.controller;

import com.alevel.trucking.dto.CustomerRegistrationForm;
import com.alevel.trucking.exception.UserEmailExistException;
import com.alevel.trucking.exception.UsernameExistException;
import com.alevel.trucking.model.person.customer.Customer;
import com.alevel.trucking.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        try {
            return ResponseEntity.ok(customerService.save(customer));
        } catch (UsernameExistException e) {
            e.printStackTrace();
            return ResponseEntity.status(403).body("User exists");
        } catch (UserEmailExistException e) {
            e.printStackTrace();
            return ResponseEntity.status(403).body("Email exists");
        }
    }

    @GetMapping()
    public ResponseEntity getMainPage() {
        return ResponseEntity.ok("Main page");
    }
}
