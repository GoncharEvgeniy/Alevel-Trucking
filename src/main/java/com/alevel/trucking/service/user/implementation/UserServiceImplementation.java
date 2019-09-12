package com.alevel.trucking.service.user.implementation;

import com.alevel.trucking.model.user.User;
import com.alevel.trucking.repository.UserRepository;
import com.alevel.trucking.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        return true; // TODO
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
