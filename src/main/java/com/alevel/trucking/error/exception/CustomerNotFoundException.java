package com.alevel.trucking.error.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String username) {
        super("Customer " + username + " not found");
    }

    public CustomerNotFoundException() {
        super("Customer not found");
    }

    public CustomerNotFoundException(Long id) {
        super("Customer id=" + id + " not found");
    }
}
