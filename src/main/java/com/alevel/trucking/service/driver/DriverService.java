package com.alevel.trucking.service.driver;

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

    List<Driver> getAllDriver();

    List<Driver> getDriversByListId(List<Long> driversId);

    List<Driver> getFreeDrivers();

    Set<Order> getOrdersByDriver(Long driverId) throws  OrderNotFoundException;

    Set<Order> getOrdersByCurrentDriver() throws OrderNotFoundException;

    Set<Order> getOrdersByCurrentDriverAndByStatus(OrderStatus status) throws OrderNotFoundException;

    Driver getCurrentDriver();

    Order startOrder(Long orderId) throws OrderNotFoundException;

    Order finishOrder(Long orderId) throws OrderNotFoundException;

    boolean deleteDriver(Long id);

    String backToBox();

}
