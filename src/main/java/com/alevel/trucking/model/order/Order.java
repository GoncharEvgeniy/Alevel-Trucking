package com.alevel.trucking.model.order;

import com.alevel.trucking.model.goods.Goods;
import com.alevel.trucking.model.person.customer.Customer;
import com.alevel.trucking.model.person.driver.Driver;
import com.alevel.trucking.model.person.manager.Manager;
import com.alevel.trucking.model.route.Route;
import com.alevel.trucking.model.transport.Transport;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cost")
    private double cost;

    @OneToOne
    @JoinColumn(name = "id_route", referencedColumnName = "id")
    private Route route;

    @OneToOne
    @JoinColumn(name = "id_manager", referencedColumnName = "id")
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "order_driver",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_driver")
    )
    private List<Driver> drivers;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "order_goods",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_goods")
    )
    private List<Goods> goods;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "order_transport",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_transport")
    )
    private List<Transport> transports;

}
