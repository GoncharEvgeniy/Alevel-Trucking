package com.alevel.trucking.model.person;

import newpost.model.order.Order;

import java.util.Set;

public class Customer extends Person {
    private Set<Order> orders;
}
