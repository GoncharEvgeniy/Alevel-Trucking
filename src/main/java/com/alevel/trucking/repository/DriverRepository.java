package com.alevel.trucking.repository;

import com.alevel.trucking.model.person.driver.Driver;
import com.alevel.trucking.model.person.driver.DriverStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DriverRepository extends JpaRepository<Driver, Long> {

    Driver findByUsername(String username);

    Driver findByEmail(String email);

    List<Driver> findAllByStatus(DriverStatus status);

}
