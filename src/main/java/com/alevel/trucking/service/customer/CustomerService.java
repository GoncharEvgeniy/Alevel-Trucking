package com.alevel.trucking.service.customer;

import com.alevel.trucking.exception.UserEmailExistException;
import com.alevel.trucking.exception.UsernameExistException;
import com.alevel.trucking.model.person.customer.Customer;

import java.util.List;

public interface CustomerService {

    boolean save(Customer customer) throws UsernameExistException, UserEmailExistException;

    Customer findByUsername(String username);

    List<Customer> getAllCustomer();

    Customer getCustomerById(Long id);

    Customer getCurrentCustomer();

    boolean deleteCustomer(Long id);

}
