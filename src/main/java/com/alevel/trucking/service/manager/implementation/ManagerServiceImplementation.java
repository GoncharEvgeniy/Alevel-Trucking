package com.alevel.trucking.service.manager.implementation;

import com.alevel.trucking.exception.UserEmailExistException;
import com.alevel.trucking.exception.UsernameExistException;
import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.order.OrderStatus;
import com.alevel.trucking.model.person.driver.Driver;
import com.alevel.trucking.model.person.driver.DriverStatus;
import com.alevel.trucking.model.person.manager.Manager;
import com.alevel.trucking.model.route.Route;
import com.alevel.trucking.model.transport.Transport;
import com.alevel.trucking.model.transport.TransportStatus;
import com.alevel.trucking.model.user.Role;
import com.alevel.trucking.model.user.User;
import com.alevel.trucking.repository.ManagerRepository;
import com.alevel.trucking.service.cost.CostCalculator;
import com.alevel.trucking.service.distance.Distance;
import com.alevel.trucking.service.driver.DriverService;
import com.alevel.trucking.service.manager.ManagerService;

import com.alevel.trucking.service.order.OrderService;
import com.alevel.trucking.service.role.RoleService;
import com.alevel.trucking.service.transport.TransportService;
import com.alevel.trucking.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    private final RoleService roleService;

    @Autowired
    public ManagerServiceImplementation(ManagerRepository managerRepository,
                                        OrderService orderService,
                                        Distance distance,
                                        CostCalculator costCalculator,
                                        TransportService transportService,
                                        DriverService driverService,
                                        PasswordEncoder passwordEncoder,
                                        UserService userService,
                                        RoleService roleService) {
        this.managerRepository = managerRepository;
        this.passwordEncoder = passwordEncoder;
        this.orderService = orderService;
        this.distance = distance;
        this.costCalculator = costCalculator;
        this.transportService = transportService;
        this.driverService = driverService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public boolean save(Manager manager) throws UsernameExistException, UserEmailExistException {
        if (userService.isUsernameExist(manager.getUsername())) {
            throw new UsernameExistException(manager.getUsername());
        }
        if (userService.isEmailExist(manager.getEmail())) {
            throw new UserEmailExistException(manager.getEmail());
        }
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        Role role = roleService.findByName("manager");
        if (Objects.isNull(role)) {
            roleService.save(new Role("manager"));
            role = roleService.findByName("manager");
        }
        manager.setRole(role);
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
        driverList.forEach(driver -> driver.setStatus(DriverStatus.IN_ROUTE));
        order.setDrivers(driverList);
        List<Transport> transportList = transportService.getTransportByListId(transportsId);
        transportList.forEach(transport -> transport.addOrder(order));
        transportList.forEach(transport -> transport.setStatus(TransportStatus.IN_ROUTE));
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
        return manager;
    }

    @Override
    public boolean deleteManager(Long id) {
        Manager manager = managerRepository
                .findById(id)
                .orElse(null);
        if (manager != null) {
            manager.setAccountNonLocked(false);
            manager.setEnabled(false);
            managerRepository.save(manager);
        }
        return true;
    }
  
}
