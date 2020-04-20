package com.alevel.trucking.repository;

import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.order.OrderStatus;
import com.alevel.trucking.model.person.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer(Customer customer);

    List<Order> findByStatusAndCustomer(OrderStatus orderStatus, Customer customer);

    List<Order> findByStatus(OrderStatus status);

}
