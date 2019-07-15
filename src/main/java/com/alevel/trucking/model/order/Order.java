package com.alevel.trucking.model.order;

import newpost.model.person.Customer;
import newpost.model.person.Manager;
import newpost.model.person.driver.Driver;
import newpost.model.transport.Transport;

import java.util.List;

public class Order {
    private Route route;
    private Customer customer;
    private List<Driver> driver;
    private Manager manager;
    private List<Goods> goods;
    private OrderStatus status;
    private List<Transport> transport;
}
