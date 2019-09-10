package com.alevel.trucking.error.exception;

import com.alevel.trucking.model.order.OrderStatus;

public class OrderNotFoundException extends Exception {

    public OrderNotFoundException() {
        super("Order not found");
    }

    public OrderNotFoundException(Long id) {
        super("Order id=" + id + " not found");
    }

    public OrderNotFoundException(OrderStatus status) {
        super("Order with=" + status + " not found");
    }
}
