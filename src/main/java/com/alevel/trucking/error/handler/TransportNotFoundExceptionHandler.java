package com.alevel.trucking.error.handler;

import com.alevel.trucking.error.exception.TransportNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransportNotFoundExceptionHandler {

    @ExceptionHandler(TransportNotFoundException.class)
    public ResponseEntity<Message> handleTransportNotFoundException(TransportNotFoundException e) {
        return new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class Message {
        private String message;
    }
}
