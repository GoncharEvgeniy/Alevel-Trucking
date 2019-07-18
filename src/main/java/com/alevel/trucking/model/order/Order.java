package com.alevel.trucking.model.order;


import com.alevel.trucking.model.goods.Goods;
import com.alevel.trucking.model.person.customer.Customer;
import com.alevel.trucking.model.person.driver.Driver;
import com.alevel.trucking.model.person.manager.Manager;
import com.alevel.trucking.model.route.Route;
import com.alevel.trucking.model.transport.Transport;

import java.util.List;

public class Order {
    private Long id;
    private Route route;
    private Customer customer;
    private List<Driver> driver;
    private Manager manager;
    private List<Goods> goods;
    private OrderStatus status;
    private List<Transport> transport;
    private double cost;
}
