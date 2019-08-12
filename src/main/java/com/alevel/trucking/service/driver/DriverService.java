package com.alevel.trucking.service.driver;

import com.alevel.trucking.model.person.driver.Driver;

import java.util.List;

public interface DriverService {

    boolean save(Driver driver);

    List<Driver> getAllDriver();

    List<Driver> getDriversByListId(List<Long> driversId);
}
