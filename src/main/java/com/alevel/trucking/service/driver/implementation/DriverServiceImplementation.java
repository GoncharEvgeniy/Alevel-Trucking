package com.alevel.trucking.service.driver.implementation;

import com.alevel.trucking.error.exception.DriverNotFoundException;
import com.alevel.trucking.error.exception.OrderNotFoundException;
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
        List<Driver> drivers = driverRepository.findAll();
        if (drivers.size() == 0) {
            throw new DriverNotFoundException();
        } else {
            return drivers;
        }
    }

    @Override
    public List<Driver> getDriversByListId(List<Long> listId) {
        List<Driver> driverList = new ArrayList<>();
        for (Long id : listId) {
            Driver driver = driverRepository
                    .findById(id)
                    .orElseThrow(() -> new DriverNotFoundException(id));
            driverList.add(driver);
        }
        return driverList;
    }

    @Override
    public List<Driver> getFreeDrivers() {
        List<Driver> drivers = driverRepository.findAllByStatus(DriverStatus.IN_BOX);
        if (drivers.size() == 0) {
            throw new DriverNotFoundException(DriverStatus.IN_BOX);
        }
        return drivers;
    }

    @Override
    public Set<Order> getOrdersByDriver(Long driverId) {
        Driver driver = driverRepository
                .findById(driverId)
                .orElseThrow(() -> new DriverNotFoundException(driverId));
        Set<Order> orders = driver.getOrders();
        if (orders == null || orders.size() == 0) {
            throw new OrderNotFoundException();
        }
        return orders;
    }

    @Override
    public Set<Order> getOrdersByCurrentDriver() {
        Driver driver = getCurrentDriver();
        Set<Order> orders = driver.getOrders();
        if (orders == null || orders.size() == 0) {
            throw new OrderNotFoundException();
        }
        return orders;
    }

    @Override
    public Set<Order> getOrdersByCurrentDriverAndByStatus(OrderStatus status) {
        Driver driver = getCurrentDriver();
        Set<Order> allOrders = driver.getOrders();
        if (allOrders == null || allOrders.size() == 0) {
            throw new OrderNotFoundException();
        }
        Set<Order> ordersByStatus = allOrders
                .stream()
                .filter(order -> order.getStatus() == status)
                .collect(Collectors.toSet());
        if (ordersByStatus.size() == 0) {
            throw new OrderNotFoundException(status);
        }
        return ordersByStatus;
    }

    @Override
    public Driver getCurrentDriver() {
        User currentUser = userService.getCurrentUser();
        Driver driver = driverRepository.findByUsername(currentUser.getUsername());
        if (driver == null) {
            throw new DriverNotFoundException(currentUser.getUsername());
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
                .orElseThrow(() -> new DriverNotFoundException(id));
        driver.setAccountNonLocked(false);
        driver.setEnabled(false);
        driverRepository.save(driver);
        return true;
    }


}
