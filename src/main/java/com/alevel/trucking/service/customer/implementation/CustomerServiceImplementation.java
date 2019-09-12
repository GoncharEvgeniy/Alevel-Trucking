package com.alevel.trucking.service.customer.implementation;

import com.alevel.trucking.error.exception.CustomerNotFoundException;
import com.alevel.trucking.model.person.customer.Customer;
import com.alevel.trucking.model.user.Role;
import com.alevel.trucking.repository.CustomerRepository;
import com.alevel.trucking.service.customer.CustomerService;
import com.alevel.trucking.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserService userService;

    @Autowired
    public CustomerServiceImplementation(CustomerRepository customerRepository,
                                         PasswordEncoder passwordEncoder,
                                         UserService userService) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public boolean save(Customer customer) {
        if (userService.isExist(customer.getUsername(), customer.getEmail())) {
            return false;
        }
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setRoles(new HashSet<>(Collections.singleton(Role.CUSTOMER)));
        customerRepository.save(customer);
        return true;
    }

    @Override
    public Customer findByUsername(String username) {
        Customer customer = customerRepository.findByUsername(username);
        if (customer == null) {
            throw new CustomerNotFoundException(username);
        } else {
            return customer;
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        if (customers.size() == 0) {
            throw new CustomerNotFoundException();
        } else {
            return customers;
        }
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public Customer getCurrentCustomer() {
        Customer currentCustomer = (Customer) SecurityContextHolder // TODO exception???
                .getContext()
                .getAuthentication()
                .getPrincipal();
        Customer customer = customerRepository.findByUsername(currentCustomer.getUsername());
        if (customer == null) {
            throw new CustomerNotFoundException(currentCustomer.getUsername());
        } else {
            return customer;
        }
    }

    @Override
    public boolean deleteCustomer(Long id) {
        Customer customer = customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        customer.setAccountNonLocked(false);
        customer.setEnabled(false);
        customerRepository.save(customer);
        return true;
    }
  
}
