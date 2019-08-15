package com.alevel.trucking.service.manager.implementation;

import com.alevel.trucking.model.person.manager.Manager;
import com.alevel.trucking.model.user.Role;
import com.alevel.trucking.repository.ManagerRepository;
import com.alevel.trucking.service.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
public class ManagerServiceImplementation implements ManagerService {

    private final ManagerRepository managerRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ManagerServiceImplementation(ManagerRepository managerRepository,
                                        PasswordEncoder passwordEncoder) {
        this.managerRepository = managerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean save(Manager manager) {
        Manager managerFromDbByName = managerRepository.findByUsername(manager.getUsername());
        Manager managerFromBbByEmail = managerRepository.findByEmail(manager.getEmail());
        if (managerFromDbByName != null || managerFromBbByEmail != null) {
            return false;
        }
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        manager.setRoles(new HashSet<>(Collections.singleton(Role.MANAGER)));
        managerRepository.save(manager);
        return true;
    }

    @Override
    public boolean deleteManager(Long id) {
        Manager manager = managerRepository.findById(id).get(); //TODO exception
        manager.setAccountNonLocked(false);
        manager.setEnabled(false);
        managerRepository.save(manager);
        return true;
    }
}
