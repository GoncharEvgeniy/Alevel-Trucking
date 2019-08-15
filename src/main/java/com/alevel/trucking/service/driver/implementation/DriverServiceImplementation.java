package com.alevel.trucking.service.driver.implementation;

import com.alevel.trucking.model.person.driver.Driver;
import com.alevel.trucking.model.person.driver.DriverLicense;
import com.alevel.trucking.model.person.driver.DriverStatus;
import com.alevel.trucking.model.user.Role;
import com.alevel.trucking.repository.DriverRepository;
import com.alevel.trucking.service.driver.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
public class DriverServiceImplementation implements DriverService {

    private final DriverRepository driverRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DriverServiceImplementation(DriverRepository driverRepository,
                                       PasswordEncoder passwordEncoder) {
        this.driverRepository = driverRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean save(Driver driver) {
        Driver driverFromDbByName = driverRepository.findByUsername(driver.getUsername());
        Driver driverFromBbByEmail = driverRepository.findByEmail(driver.getEmail());
        if (driverFromDbByName != null || driverFromBbByEmail != null) {
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
