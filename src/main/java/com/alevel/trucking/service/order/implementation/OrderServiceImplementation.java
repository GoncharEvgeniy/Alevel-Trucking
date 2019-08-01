package com.alevel.trucking.service.order.implementation;

import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.order.OrderStatus;
import com.alevel.trucking.model.person.customer.Customer;
import com.alevel.trucking.repository.OrderRepository;
import com.alevel.trucking.service.customer.CustomerService;
import com.alevel.trucking.service.order.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Log4j2
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    private final CustomerService customerService;

    @Autowired
    public OrderServiceImplementation(OrderRepository orderRepository, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
    }

    @Override
    public Order save(Order order) {
        Customer currentCustomer = (Customer) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        Customer customer = customerService.findByUsername(currentCustomer.getUsername());
        Set<Order> customerOrders = customer.getOrders();
        if (customerOrders == null) {
            customerOrders = new HashSet<>();
        }
        customerOrders.add(order);
        customer.setOrders(customerOrders);
        order.setStatus(OrderStatus.WAITING);
        order.setCustomer(customer);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrdersByCustomer() {
        Customer currentCustomer = (Customer) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        Customer customer = customerService.findByUsername(currentCustomer.getUsername());
        return orderRepository.findByCustomer(customer);
    }
}
