package com.alevel.trucking.service.manager.implementation;

import com.alevel.trucking.error.exception.ManagerNotFoundException;
import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.order.OrderStatus;
import com.alevel.trucking.model.person.driver.Driver;
import com.alevel.trucking.model.person.manager.Manager;
import com.alevel.trucking.model.route.Route;
import com.alevel.trucking.model.transport.Transport;
import com.alevel.trucking.model.user.Role;
import com.alevel.trucking.model.user.User;
import com.alevel.trucking.repository.ManagerRepository;
import com.alevel.trucking.service.cost.CostCalculator;
import com.alevel.trucking.service.distance.Distance;
import com.alevel.trucking.service.driver.DriverService;
import com.alevel.trucking.service.manager.ManagerService;
import com.alevel.trucking.service.order.OrderService;
import com.alevel.trucking.service.transport.TransportService;
import com.alevel.trucking.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class ManagerServiceImplementation implements ManagerService {

    private final ManagerRepository managerRepository;

    private final PasswordEncoder passwordEncoder;

    private final OrderService orderService;

    private final Distance distance;

    private final CostCalculator costCalculator;

    private final TransportService transportService;

    private final DriverService driverService;

    private final UserService userService;

    @Autowired
    public ManagerServiceImplementation(ManagerRepository managerRepository,
                                        OrderService orderService,
                                        Distance distance,
                                        CostCalculator costCalculator,
                                        TransportService transportService,
                                        DriverService driverService,
                                        PasswordEncoder passwordEncoder,
                                        UserService userService) {
        this.managerRepository = managerRepository;
        this.passwordEncoder = passwordEncoder;
        this.orderService = orderService;
        this.distance = distance;
        this.costCalculator = costCalculator;
        this.transportService = transportService;
        this.driverService = driverService;
        this.userService = userService;
    }

    @Override
    public boolean save(Manager manager) {
        if (userService.isExist(manager.getUsername(), manager.getEmail())) {
            return false;
        }
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        manager.setRoles(new HashSet<>(Collections.singleton(Role.MANAGER)));
        managerRepository.save(manager);
        return true;
    }

    @Override
    public Order acceptOrder(Long orderId, List<Long> transportsId, List<Long> driversId) {
        Order order = orderService.getOrderById(orderId);
        Route route = order.getRoute();
        double routeDistance = distance.getDistance(route.getStart(), route.getEnd());
        route.setDistance(routeDistance);
        List<Driver> driverList = driverService.getDriversByListId(driversId);
        driverList.forEach(driver -> driver.addOrder(order));
        order.setDrivers(driverList);
        List<Transport> transportList = transportService.getTransportByListId(transportsId);
        transportList.forEach(transport -> transport.addOrder(order));
        order.setTransports(transportList);
        double cost = costCalculator.getCost(order);
        order.setCost(cost);
        order.setStatus(OrderStatus.ACCEPTED);
        order.setManager(getCurrentManager());
        return orderService.update(order);
    }

    @Override
    public Manager getCurrentManager() {
        User currentUser = userService.getCurrentUser();
        Manager manager = managerRepository.findByUsername(currentUser.getUsername());
        if (manager == null) {
            throw new ManagerNotFoundException(currentUser.getUsername());
        } else {
            return manager;
        }
    }

    @Override
    public boolean deleteManager(Long id) {
        Manager manager = managerRepository
                .findById(id)
                .orElseThrow(() -> new ManagerNotFoundException(id));
        manager.setAccountNonLocked(false);
        manager.setEnabled(false);
        managerRepository.save(manager);
        return true;
    }
}
