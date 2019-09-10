package com.alevel.trucking.service.customer;

import com.alevel.trucking.error.exception.CustomerNotFoundException;
import com.alevel.trucking.error.exception.UserEmailExistException;
import com.alevel.trucking.error.exception.UsernameExistException;
import com.alevel.trucking.model.person.customer.Customer;

import java.util.List;

public interface CustomerService {

    boolean save(Customer customer) throws UsernameExistException, UserEmailExistException;

    Customer findByUsername(String username) throws CustomerNotFoundException;

    List<Customer> getAllCustomer() throws CustomerNotFoundException;

    Customer getCustomerById(Long id) throws CustomerNotFoundException;

    Customer getCurrentCustomer() throws CustomerNotFoundException;

    boolean deleteCustomer(Long id) throws CustomerNotFoundException;
}
