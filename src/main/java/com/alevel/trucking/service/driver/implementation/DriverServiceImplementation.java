package com.alevel.trucking.service.driver.implementation;

import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.order.OrderStatus;
import com.alevel.trucking.model.person.driver.Driver;
import com.alevel.trucking.model.person.driver.DriverLicense;
import com.alevel.trucking.model.person.driver.DriverStatus;
import com.alevel.trucking.model.user.Role;
import com.alevel.trucking.model.user.User;
import com.alevel.trucking.repository.DriverRepository;
import com.alevel.trucking.service.driver.DriverService;

import com.alevel.trucking.service.order.OrderService;

import com.alevel.trucking.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DriverServiceImplementation implements DriverService {

    private final DriverRepository driverRepository;

    private final OrderService orderService;

    private final PasswordEncoder passwordEncoder;

    private final UserService userService;

    @Autowired
    public DriverServiceImplementation(DriverRepository driverRepository,
                                       OrderService orderService,
                                       PasswordEncoder passwordEncoder,
                                       UserService userService) {
        this.driverRepository = driverRepository;
        this.orderService = orderService;
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
        Order order = orderService.getOrderById(orderId).get(); // exception
        order.setStatus(OrderStatus.ON_WAY);
        return orderService.update(order);
    }

    @Override
    public Order finishOrder(Long orderId) {
        Order order = orderService.getOrderById(orderId).get(); // exception
        order.setStatus(OrderStatus.DONE);
        return orderService.update(order);
    }

    public boolean deleteDriver(Long id) {
        Driver driver = driverRepository.findById(id).get(); //TODO exception
        driver.setAccountNonLocked(false);
        driver.setEnabled(false);
        driverRepository.save(driver);
        return true;
    }

}
