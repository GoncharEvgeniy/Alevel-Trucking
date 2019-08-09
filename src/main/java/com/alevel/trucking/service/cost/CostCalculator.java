package com.alevel.trucking.service.cost;

import com.alevel.trucking.model.order.Order;

public interface CostCalculator {

    double getCost(Order order);
}
