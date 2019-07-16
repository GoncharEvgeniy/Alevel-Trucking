package com.alevel.trucking.model.person;


import com.alevel.trucking.model.order.Order;

import java.util.Set;

public class Customer extends Person {
    private Set<Order> orders;
}
