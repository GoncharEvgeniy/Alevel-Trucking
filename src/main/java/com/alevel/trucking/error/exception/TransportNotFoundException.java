package com.alevel.trucking.error.exception;

public class TransportNotFoundException extends RuntimeException {

    public TransportNotFoundException() {
        super("Transport not found");
    }

    public TransportNotFoundException(Long id) {
        super("Transport id=" + id + " not found");
    }

}
