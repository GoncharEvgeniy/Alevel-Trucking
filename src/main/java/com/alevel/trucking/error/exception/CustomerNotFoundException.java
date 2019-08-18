package com.alevel.trucking.error.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super("Customer id=" + id + " not found");
    }
}
