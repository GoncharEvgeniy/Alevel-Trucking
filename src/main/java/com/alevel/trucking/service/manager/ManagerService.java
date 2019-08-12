package com.alevel.trucking.service.manager;

import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.person.manager.Manager;

import java.util.List;

public interface ManagerService {

    boolean save(Manager manager);

    Order acceptOrder(Long orderId, List<Long> transportsId, List<Long> driversId);

    Manager getCurrentManager();
}
