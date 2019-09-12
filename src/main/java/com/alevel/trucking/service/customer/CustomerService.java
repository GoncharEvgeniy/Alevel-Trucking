package com.alevel.trucking.service.customer;

import com.alevel.trucking.model.person.customer.Customer;

public interface CustomerService {

    boolean save(Customer customer);

    Customer findByUsername(String username);

    boolean deleteCustomer(Long id);
}
