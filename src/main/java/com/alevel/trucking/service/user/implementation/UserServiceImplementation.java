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
    public boolean isExist(String username, String email) {
        User userFromDbByName = userRepository.findByUsername(username);
        User userFromBbByEmail = userRepository.findByEmail(email);
        if (userFromDbByName != null || userFromBbByEmail != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getCurrentUser() {
        User currentUser = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return currentUser;
    }
}
