package com.alevel.trucking.service.admin.implementation;

import com.alevel.trucking.model.user.User;
import com.alevel.trucking.repository.UserRepository;
import com.alevel.trucking.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImplementation implements AdminService {

    private final UserRepository userRepository;

    @Autowired
    public AdminServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
