package com.alevel.trucking.service.order;

import com.alevel.trucking.model.order.Order;

import java.util.List;

public interface OrderService {

    Order save(Order order);

    List<Order> getAllOrdersByCurrentCustomer();

    List<Order> getOrdersByCurrentCustomerAndStatus(String status);
}
