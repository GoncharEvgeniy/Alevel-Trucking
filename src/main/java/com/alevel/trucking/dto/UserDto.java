package com.alevel.trucking.dto;

import com.alevel.trucking.model.user.User;

public class UserDto {

    private String login;

    private String firstName;

    private String lastName;

    private String role;

    public UserDto() {
    }

    public UserDto(String login, String firstName, String lastName, String role) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.login = user.getUsername();
        this.lastName = user.getLastName();
        this.role = user.getRole().getName();
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
