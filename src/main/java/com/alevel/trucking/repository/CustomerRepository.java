package com.alevel.trucking.repository;

import com.alevel.trucking.model.person.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByUsername(String username);

    Customer findByEmail(String email);
}
