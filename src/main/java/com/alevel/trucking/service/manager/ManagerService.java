package com.alevel.trucking.service.manager;

import com.alevel.trucking.error.exception.*;
import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.person.manager.Manager;

import java.util.List;

public interface ManagerService {

    boolean save(Manager manager) throws UsernameExistException, UserEmailExistException;

    Order acceptOrder(Long orderId, List<Long> transportsId, List<Long> driversId) throws DriverNotFoundException, ManagerNotFoundException, OrderNotFoundException, TransportNotFoundException;

    Manager getCurrentManager() throws ManagerNotFoundException;

    boolean deleteManager(Long id) throws ManagerNotFoundException;
}
