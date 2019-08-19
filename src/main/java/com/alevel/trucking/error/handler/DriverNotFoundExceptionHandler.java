package com.alevel.trucking.error.handler;

import com.alevel.trucking.error.exception.DriverNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DriverNotFoundExceptionHandler {

    @ExceptionHandler(DriverNotFoundException.class)
    public ResponseEntity<Message> handleDriverNotFoundException(DriverNotFoundException e) {
        return new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class Message {
        private String message;
    }
}
