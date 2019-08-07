package com.alevel.trucking.service.order;

import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.order.OrderStatus;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order save(Order order);

    List<Order> getAllOrdersByCurrentCustomer();

    List<Order> getOrdersByCurrentCustomerAndStatus(String status);

    List<Order> getAllOrder();

    List<Order> getOrderByCustomerId(Long id);

    List<Order> getAllOrdersByStatus(OrderStatus status);

    Optional<Order> getOrderById(Long orderId);
}
