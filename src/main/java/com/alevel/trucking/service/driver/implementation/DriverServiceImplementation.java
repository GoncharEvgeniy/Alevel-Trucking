package com.alevel.trucking.service.driver.implementation;

import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.order.OrderStatus;
import com.alevel.trucking.model.person.driver.Driver;
import com.alevel.trucking.model.person.driver.DriverLicense;
import com.alevel.trucking.model.person.driver.DriverStatus;
import com.alevel.trucking.model.user.Role;
import com.alevel.trucking.repository.DriverRepository;
import com.alevel.trucking.service.driver.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
    public List<Driver> getAllDriver() {
        return driverRepository.findAll();
    }

    @Override
    public List<Driver> getDriversByListId(List<Long> listId) {
        List<Driver> driverList = new ArrayList<>();
        for (Long id : listId) {
            Driver driver = driverRepository.findById(id).get(); //Todo exception
            driverList.add(driver);
        }
        return driverList;
    }

    @Override
    public List<Driver> getFreeDrivers() {
        return driverRepository.findAllByStatus(DriverStatus.IN_BOX);
    }

    @Override
    public Set<Order> getOrdersByDriver(Long driverId) {
        return driverRepository.findById(driverId).get().getOrders(); //todo exception
    }

    @Override
    public Set<Order> getOrdersByCurrentDriver() {
        Driver driver = getCurrentDriver();
        return driver.getOrders();
    }

    @Override
    public Set<Order> getOrdersByCurrentDriverAndByStatus(OrderStatus status) {
        Driver driver = getCurrentDriver();
        Set<Order> allOrders = driver.getOrders();
        Set<Order> ordersByStatus = allOrders
                .stream()
                .filter(order -> order.getStatus() == status)
                .collect(Collectors.toSet());
        return ordersByStatus;
    }

    @Override
    public Driver getCurrentDriver() {
        Driver currentDriver = (Driver) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return driverRepository.findByUsername(currentDriver.getUsername());
    }

    @Override
    public Order startOrder(Long orderId) {
        return null;
    }

    @Override
    public Order finishOrder(Long orderId) {
        return null;
    }
}
