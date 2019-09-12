package com.alevel.trucking.service.user;

import com.alevel.trucking.model.user.User;

import java.util.List;

public interface UserService {

    boolean save(User user);

    List<User> getAllUser();
}
