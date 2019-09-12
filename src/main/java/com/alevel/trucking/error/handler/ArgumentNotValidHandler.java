package com.alevel.trucking.error.handler;

import com.alevel.trucking.error.exception.UserEmailExistException;
import com.alevel.trucking.error.exception.UsernameExistException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ArgumentNotValidHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsernameExistException.class)
    public ResponseEntity<Message> handleUserExistException(UsernameExistException e) {
        return new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserEmailExistException.class)
    public ResponseEntity<Message> handleUserEmailExistException(UserEmailExistException e) {
        return new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors().stream()
                .map(f -> new FieldError(f.getObjectName(), f.getField(), f.getCode()))
                .collect(Collectors.toList());
        return handleExceptionInternal(ex,
                "Method argument not valid, fieldErrors:" + fieldErrors,
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request);
    }

    @Data
    @AllArgsConstructor
    private static class Message {
        private String message;
    }
}
