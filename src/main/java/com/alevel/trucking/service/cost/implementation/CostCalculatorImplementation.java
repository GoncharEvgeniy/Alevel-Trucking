package com.alevel.trucking.service.cost.implementation;

import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.transport.Transport;
import com.alevel.trucking.service.cost.CostCalculator;
import org.springframework.stereotype.Component;

@Component
public class CostCalculatorImplementation implements CostCalculator {

    private final static int CONVERT_TO_KM = 1000;

    @Override
    public double getCost(Order order) {
        double sumCostPerOneKilometer = order.getTransports()
                .stream()
                .mapToDouble(Transport::getCostPerOneKilometer)
                .sum();
        return sumCostPerOneKilometer * order.getRoute().getDistance() / CONVERT_TO_KM;
    }
}
