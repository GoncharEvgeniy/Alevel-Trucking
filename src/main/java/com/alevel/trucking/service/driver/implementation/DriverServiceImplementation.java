package com.alevel.trucking.service.driver.implementation;

import com.alevel.trucking.model.person.driver.Driver;
import com.alevel.trucking.model.person.driver.DriverLicense;
import com.alevel.trucking.model.person.driver.DriverStatus;
import com.alevel.trucking.model.user.Role;
import com.alevel.trucking.model.user.User;
import com.alevel.trucking.repository.DriverRepository;
import com.alevel.trucking.service.driver.DriverService;
import com.alevel.trucking.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
public class DriverServiceImplementation implements DriverService {

    private final DriverRepository driverRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserService userService;

    @Autowired
    public DriverServiceImplementation(DriverRepository driverRepository,
                                       PasswordEncoder passwordEncoder,
                                       UserService userService) {
        this.driverRepository = driverRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public boolean save(Driver driver) {
        if (userService.isExist(driver.getUsername(), driver.getEmail())) {
            return false;
        }
        driver.setPassword(passwordEncoder.encode(driver.getPassword()));
        DriverLicense driverLicense = driver.getDriverLicense();
        driverLicense.setDriver(driver);
        driver.setRoles(new HashSet<>(Collections.singleton(Role.DRIVER)));
        driver.setStatus(DriverStatus.IN_BOX);
        driverRepository.save(driver);
        return true;
    }

    @Override
    public boolean deleteManager(Long id) {
        Driver driver = driverRepository.findById(id).get(); //TODO exception
        driver.setAccountNonLocked(false);
        driver.setEnabled(false);
        driverRepository.save(driver);
        return true;
    }


}
