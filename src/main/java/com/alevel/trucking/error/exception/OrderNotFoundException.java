package com.alevel.trucking.error.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException() {
        super("Order not found");
    }

    public OrderNotFoundException(Long id) {
        super("Order id=" + id + "not found");
    }
}
