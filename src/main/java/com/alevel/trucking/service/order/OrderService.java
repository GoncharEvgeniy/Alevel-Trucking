package com.alevel.trucking.service.order;

import com.alevel.trucking.error.exception.OrderNotFoundException;
import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.order.OrderStatus;

import java.util.List;

public interface OrderService {

    Order saveNewOrder(Order order);

    List<Order> getAllOrdersByCurrentCustomer();

    List<Order> getOrdersByCurrentCustomerAndStatus(String status) throws OrderNotFoundException;

    List<Order> getAllOrder() throws OrderNotFoundException;

    List<Order> getOrdersByCustomerId(Long customerId) throws OrderNotFoundException;

    List<Order> getAllOrdersByStatus(OrderStatus status) throws OrderNotFoundException;

    Order getOrderById(Long orderId) throws OrderNotFoundException;

    Order update(Order order);
}
