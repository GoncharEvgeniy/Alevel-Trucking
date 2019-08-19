package com.alevel.trucking.service.order.implementation;

import com.alevel.trucking.error.exception.OrderNotFoundException;
import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.order.OrderStatus;
import com.alevel.trucking.model.person.customer.Customer;
import com.alevel.trucking.repository.OrderRepository;
import com.alevel.trucking.service.customer.CustomerService;
import com.alevel.trucking.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    private final CustomerService customerService;

    @Autowired
    public OrderServiceImplementation(OrderRepository orderRepository,
                                      CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
    }

    @Override
    public Order saveNewOrder(Order order) {
        Customer customer = customerService.getCurrentCustomer();
        customer.addOrder(order);
        order.setStatus(OrderStatus.WAITING);
        order.setCustomer(customer);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrdersByCurrentCustomer() {
        Customer customer = customerService.getCurrentCustomer();
        return orderRepository.findByCustomer(customer);
    }

    @Override
    public List<Order> getOrdersByCurrentCustomerAndStatus(String status) {
        OrderStatus orderStatus = OrderStatus.valueOf(status);
        Customer customer = customerService.getCurrentCustomer();
        List<Order> orders = orderRepository.findByStatusAndCustomer(orderStatus, customer);
        if (orders.size() == 0) {
            throw new OrderNotFoundException();
        } else {
            return orders;
        }
    }

    @Override
    public List<Order> getAllOrder() {
        List<Order> orders = orderRepository.findAll();
        if (orders.size() == 0) {
            throw new OrderNotFoundException();
        } else {
            return orders;
        }
    }

    @Override
    public List<Order> getOrdersByCustomerId(Long id) {
        Customer customer = customerService.getCustomerById(id);
        List<Order> orders = orderRepository.findByCustomer(customer);
        if (orders.size() == 0) {
            throw new OrderNotFoundException();
        } else {
            return orders;
        }
    }

    @Override
    public List<Order> getAllOrdersByStatus(OrderStatus status) {
        List<Order> orders = orderRepository.findByStatus(status);
        if (orders.size() == 0) {
            throw new OrderNotFoundException();
        } else {
            return orders;
        }
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository
                .findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

}
