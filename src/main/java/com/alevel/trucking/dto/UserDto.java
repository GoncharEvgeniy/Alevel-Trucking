package com.alevel.trucking.dto;

import com.alevel.trucking.model.user.User;

public class UserDto {

    private String login;

    private String firstName;

    private String lastName;

    private String secondName;

    private String email;

    private String phone;

    private String role;

    public UserDto() {
    }

    public UserDto(String login,
                   String firstName,
                   String lastName,
                   String secondName,
                   String email,
                   String phone,
                   String role) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.login = user.getUsername();
        this.lastName = user.getLastName();
        this.role = user.getRole().getName();
        this.secondName = user.getSecondName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
