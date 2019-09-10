package com.alevel.trucking.service.user.implementation;

import com.alevel.trucking.model.user.User;
import com.alevel.trucking.repository.UserRepository;
import com.alevel.trucking.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean isUsernameExist(String username) {
        User userFromDbByName = userRepository.findByUsername(username);
        return userFromDbByName != null;
    }

    @Override
    public boolean isEmailExist(String email) {
        User userFromBbByEmail = userRepository.findByEmail(email);
        return userFromBbByEmail != null;
    }

    @Override
    public User getCurrentUser() {
        User currentUser = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return currentUser; //todo
    }
}
