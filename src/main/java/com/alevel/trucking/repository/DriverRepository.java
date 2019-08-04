package com.alevel.trucking.repository;

import com.alevel.trucking.model.person.driver.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Driver findByUsername(String username);

    Driver findByEmail(String email);
    
}
