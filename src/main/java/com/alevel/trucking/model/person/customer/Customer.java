package com.alevel.trucking.model.person.customer;


import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.person.Person;

import java.util.Set;

public class Customer extends Person {
    private Set<Order> orders;
}
