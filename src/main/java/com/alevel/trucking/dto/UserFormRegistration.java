package com.alevel.trucking.dto;

import com.alevel.trucking.model.user.User;

import java.io.Serializable;

public class UserFormRegistration implements Serializable {

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String secondName;

    private String lastName;

    private String phone;

    public UserFormRegistration() {
    }

    public UserFormRegistration(String username, String password, String email,
                                String firstName, String secondName, String lastName, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public static User fromUserDto(UserFormRegistration userFormRegistration){
        User user = new User();
        user.setUsername(userFormRegistration.getUsername());
        user.setEmail(userFormRegistration.getEmail());
        user.setPassword(userFormRegistration.getPassword()); // TODO шифр
        user.setFirstName(userFormRegistration.getFirstName());
        user.setSecondName(userFormRegistration.getSecondName());
        user.setLastName(userFormRegistration.getLastName());
        user.setPhone(userFormRegistration.getPhone());
        return user;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
