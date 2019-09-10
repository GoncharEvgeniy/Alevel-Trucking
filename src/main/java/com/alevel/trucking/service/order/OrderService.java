package com.alevel.trucking.service.order;

import com.alevel.trucking.error.exception.CustomerNotFoundException;
import com.alevel.trucking.error.exception.OrderNotFoundException;
import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.order.OrderStatus;

import java.util.List;

public interface OrderService {

    Order saveNewOrder(Order order) throws CustomerNotFoundException;

    List<Order> getAllOrdersByCurrentCustomer() throws CustomerNotFoundException;

    List<Order> getOrdersByCurrentCustomerAndStatus(String status)
            throws CustomerNotFoundException, OrderNotFoundException;

    List<Order> getAllOrder() throws OrderNotFoundException;

    List<Order> getOrdersByCustomerId(Long customerId) throws CustomerNotFoundException, OrderNotFoundException;

    List<Order> getAllOrdersByStatus(OrderStatus status) throws OrderNotFoundException;

    Order getOrderById(Long orderId) throws OrderNotFoundException;

    Order update(Order order);
}
