package com.alevel.trucking.service.driver.implementation;

import com.alevel.trucking.error.exception.UserEmailExistException;
import com.alevel.trucking.error.exception.UsernameExistException;
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
    public boolean save(Driver driver) throws UserEmailExistException, UsernameExistException {
        if (userService.isUsernameExist(driver.getUsername())) {
            throw new UsernameExistException(driver.getUsername());
        }
        if (userService.isEmailExist(driver.getEmail())) {
            throw new UserEmailExistException(driver.getEmail());
        }
        driver.setPassword(passwordEncoder.encode(driver.getPassword()));
        DriverLicense driverLicense = driver.getDriverLicense();
        driverLicense.setDriver(driver);
        driver.setRole(new Role("driver"));
        driver.setStatus(DriverStatus.IN_BOX);
        driverRepository.save(driver);
        return true;
    }

    @Override
    public List<Driver> getAllDriver() {
        List<Driver> drivers = driverRepository.findAll();
        return drivers;
    }

    @Override
    public List<Driver> getDriversByListId(List<Long> listId) {
        List<Driver> driverList = new ArrayList<>();
        for (Long id : listId) {
            Driver driver = driverRepository
                    .findById(id)
                    .orElseThrow(null);
            if (driver != null) {
                driverList.add(driver);
            }
        }
        return driverList;
    }

    @Override
    public List<Driver> getFreeDrivers() {
        List<Driver> drivers = driverRepository.findAllByStatus(DriverStatus.IN_BOX);
        return drivers;
    }

    @Override
    public Set<Order> getOrdersByDriver(Long driverId) {
        Driver driver = driverRepository
                .findById(driverId)
                .orElseThrow(null);
        Set<Order> orders = new HashSet<>();
        if (driver != null) {
            orders = driver.getOrders();
        }
        return orders;
    }

    @Override
    public Set<Order> getOrdersByCurrentDriver() {
        Driver driver = getCurrentDriver();
        Set<Order> orders = new HashSet<>();
        if (driver != null) {
            orders = driver.getOrders();
        }
        return orders;
    }

    @Override
    public Set<Order> getOrdersByCurrentDriverAndByStatus(OrderStatus status)  {
        Driver driver = getCurrentDriver();
        Set<Order> ordersByStatus = new HashSet<>();
        if (driver != null) {
            Set<Order> allOrders = driver.getOrders();
            ordersByStatus = allOrders
                    .stream()
                    .filter(order -> order.getStatus() == status)
                    .collect(Collectors.toSet());
        }
        return ordersByStatus;
    }

    @Override
    public Driver getCurrentDriver() {
        User currentUser = userService.getCurrentUser();
        Driver driver = driverRepository.findByUsername(currentUser.getUsername());
        if (driver == null) {
            return null;
        } else {
            return driver;
        }
    }

    @Override
    public Order startOrder(Long orderId) {
        Order order = orderService.getOrderById(orderId);
        order.setStatus(OrderStatus.ON_WAY);
        return orderService.update(order);
    }

    @Override
    public Order finishOrder(Long orderId) {
        Order order = orderService.getOrderById(orderId);
        order.setStatus(OrderStatus.DONE);
        return orderService.update(order);
    }

    @Override
    public boolean deleteDriver(Long id) {
        Driver driver = driverRepository
                .findById(id)
                .orElseThrow(null);
        if (driver == null) {
            return false;
        }
        driver.setAccountNonLocked(false);
        driver.setEnabled(false);
        driverRepository.save(driver);
        return true;
    }

    @Override
    public String backToBox() {
        // todo not done
        return "not done";
    }

}
