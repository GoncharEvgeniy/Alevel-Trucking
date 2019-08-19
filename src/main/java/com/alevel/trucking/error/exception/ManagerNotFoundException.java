package com.alevel.trucking.error.exception;

public class ManagerNotFoundException extends RuntimeException {

    public ManagerNotFoundException() {
        super("Manager not found");
    }

    public ManagerNotFoundException(Long id) {
        super("Manager id=" + id + " not found");
    }

    public ManagerNotFoundException(String username) {
        super("Manager with username=" + username + " not found");
    }
}
