package com.alevel.trucking.repository;

import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.person.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer(Customer customer);
}
