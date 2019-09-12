package com.alevel.trucking.error.exception;

import com.alevel.trucking.model.person.driver.DriverStatus;

public class DriverNotFoundException extends RuntimeException {

    public DriverNotFoundException() {
        super("Driver not found");
    }

    public DriverNotFoundException(String username) {
        super("Driver with username=" + username + " not found");
    }

    public DriverNotFoundException(DriverStatus status) {
        super("Driver with status=" + status.toString() + " not found");
    }

    public DriverNotFoundException(Long id) {
        super("Driver id=" + id + " not found");
    }
}
