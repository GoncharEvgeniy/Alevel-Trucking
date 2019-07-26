package com.alevel.trucking.model.person.customer;


import com.alevel.trucking.model.user.User;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@NoArgsConstructor
public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /*private Set<Order> orders;*/
}
