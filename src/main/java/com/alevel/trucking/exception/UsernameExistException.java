package com.alevel.trucking.exception;

public class UsernameExistException extends Exception {

    public UsernameExistException(String username) {
        super("Username: " + username + " exist");
    }
}
