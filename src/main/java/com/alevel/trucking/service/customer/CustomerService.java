package com.alevel.trucking.service.customer;

import com.alevel.trucking.model.person.customer.Customer;

import java.util.List;

public interface CustomerService {

    boolean save(Customer customer);

    Customer findByUsername(String username);

    List<Customer> getAllCustomer();

    Customer getCustomerById(Long id);

    Customer getCurrentCustomer();

    boolean deleteCustomer(Long id);
}
