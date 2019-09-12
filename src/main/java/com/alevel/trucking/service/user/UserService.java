package com.alevel.trucking.service.user;

import com.alevel.trucking.model.user.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    User findByUsername(String username);

    User findByEmail(String email);

    boolean isUsernameExist(String username);

    boolean isEmailExist(String email);

    User getCurrentUser();
}
