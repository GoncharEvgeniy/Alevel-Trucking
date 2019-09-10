package com.alevel.trucking.service.driver;

import com.alevel.trucking.error.exception.DriverNotFoundException;
import com.alevel.trucking.error.exception.OrderNotFoundException;
import com.alevel.trucking.error.exception.UserEmailExistException;
import com.alevel.trucking.error.exception.UsernameExistException;
import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.order.OrderStatus;
import com.alevel.trucking.model.person.driver.Driver;

import java.util.List;
import java.util.Set;

public interface DriverService {

    boolean save(Driver driver) throws UserEmailExistException, UsernameExistException;

    List<Driver> getAllDriver() throws DriverNotFoundException;

    List<Driver> getDriversByListId(List<Long> driversId) throws DriverNotFoundException;

    List<Driver> getFreeDrivers() throws DriverNotFoundException;

    Set<Order> getOrdersByDriver(Long driverId) throws DriverNotFoundException, OrderNotFoundException;

    Set<Order> getOrdersByCurrentDriver() throws OrderNotFoundException, DriverNotFoundException;

    Set<Order> getOrdersByCurrentDriverAndByStatus(OrderStatus status) throws OrderNotFoundException, DriverNotFoundException;

    Driver getCurrentDriver() throws DriverNotFoundException;

    Order startOrder(Long orderId) throws OrderNotFoundException;

    Order finishOrder(Long orderId) throws OrderNotFoundException;

    boolean deleteDriver(Long id) throws DriverNotFoundException;

    String  backToBox();
}
