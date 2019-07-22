package com.alevel.trucking.model.person.customer;


import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.user.User;

import java.util.Set;

public class Customer extends User {
    private Set<Order> orders;
}
