package com.alevel.trucking.exception;

public class UserEmailExistException extends Exception {

    public UserEmailExistException(String email) {
        super("Email: " + email + " exist");
    }
}
