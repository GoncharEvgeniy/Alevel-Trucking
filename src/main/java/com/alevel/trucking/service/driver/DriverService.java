package com.alevel.trucking.service.driver;

import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.order.OrderStatus;
import com.alevel.trucking.model.person.driver.Driver;

import java.util.List;
import java.util.Set;

public interface DriverService {

    boolean save(Driver driver);

    List<Driver> getAllDriver();

    List<Driver> getDriversByListId(List<Long> driversId);

    List<Driver> getFreeDrivers();

    Set<Order> getOrdersByDriver(Long driverId);

    Set<Order> getOrdersByCurrentDriver();

    Set<Order> getOrdersByCurrentDriverAndByStatus(OrderStatus status);

    Driver getCurrentDriver();

    Order startOrder(Long orderId);

    Order finishOrder(Long orderId);

    boolean deleteDriver(Long id);

}
