package com.alevel.trucking.error.exception;

public class UserEmailExistException extends Exception {

    public UserEmailExistException(String email) {
        super("Email: " + email + " exist");
    }
}
