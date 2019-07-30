package com.alevel.trucking.service.implementation;

import com.alevel.trucking.model.user.Role;
import com.alevel.trucking.model.user.User;
import com.alevel.trucking.repository.UserRepository;
import com.alevel.trucking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean save(User user) {
        User userFromDbByName = userRepository.findByUsername(user.getUsername());
        User userFromBbByEmail = userRepository.findByEmail(user.getEmail());
        if (userFromDbByName != null || userFromBbByEmail != null) {
            return false;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(Collections.singleton(Role.CUSTOMER))); //TODO подумать
        userRepository.save(user);
        return true;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
