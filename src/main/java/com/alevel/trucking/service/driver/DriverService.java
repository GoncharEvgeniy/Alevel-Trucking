package com.alevel.trucking.service.driver;

import com.alevel.trucking.model.person.driver.Driver;

public interface DriverService {

    boolean save(Driver driver);

    boolean deleteManager(Long id);
}
