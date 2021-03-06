package com.alevel.trucking.service.customer.implementation;

import com.alevel.trucking.exception.UserEmailExistException;
import com.alevel.trucking.exception.UsernameExistException;
import com.alevel.trucking.model.person.customer.Customer;
import com.alevel.trucking.model.user.Role;
import com.alevel.trucking.model.user.User;
import com.alevel.trucking.repository.CustomerRepository;
import com.alevel.trucking.repository.RoleRepository;
import com.alevel.trucking.service.customer.CustomerService;
import com.alevel.trucking.service.role.RoleService;
import com.alevel.trucking.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public CustomerServiceImplementation(CustomerRepository customerRepository,
                                         PasswordEncoder passwordEncoder,
                                         UserService userService,
                                         RoleService roleService) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public boolean save(Customer customer) throws UsernameExistException, UserEmailExistException {
        if (userService.isUsernameExist(customer.getUsername())) {
            throw new UsernameExistException(customer.getUsername());
        }
        if (userService.isEmailExist(customer.getEmail())) {
            throw new UserEmailExistException(customer.getEmail());
        }
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        Role role = roleService.findByName("customer");
        if (Objects.isNull(role)) {
            role = roleService.save(new Role("customer"));
        }
        customer.setRole(role);
        customerRepository.save(customer);
        return true;
    }

    @Override
    public Customer findByUsername(String username) {
        Customer customer = customerRepository.findByUsername(username);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public Customer getCurrentCustomer() {
        User currentUser = userService.getCurrentUser();
        Customer customer = customerRepository.findByUsername(currentUser.getUsername());
        return customer;
    }

    @Override
    public boolean deleteCustomer(Long id) {
        Customer customer = customerRepository
                .findById(id)
                .orElse(null);
        if (customer == null) {
            return false;
        }
        customer.setAccountNonLocked(false);
        customer.setEnabled(false);
        customerRepository.save(customer);
        return true;
    }
  
}
