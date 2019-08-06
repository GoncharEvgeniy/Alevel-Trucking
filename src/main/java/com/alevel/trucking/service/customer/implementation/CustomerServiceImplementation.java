package com.alevel.trucking.service.customer.implementation;

import com.alevel.trucking.model.person.customer.Customer;
import com.alevel.trucking.model.user.Role;
import com.alevel.trucking.repository.CustomerRepository;
import com.alevel.trucking.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerServiceImplementation(CustomerRepository customerRepository,
                                         PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean save(Customer customer) {
        Customer customerFromDbByName = customerRepository.findByUsername(customer.getUsername());
        Customer customerFromBbByEmail = customerRepository.findByEmail(customer.getEmail());
        if (customerFromDbByName != null || customerFromBbByEmail != null) {
            return false;
        }
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setRoles(new HashSet<>(Collections.singleton(Role.CUSTOMER)));
        customerRepository.save(customer);
        return true;
    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
}
