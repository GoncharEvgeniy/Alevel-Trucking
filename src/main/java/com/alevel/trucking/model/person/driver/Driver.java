package com.alevel.trucking.model.person.driver;

import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.user.User;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "driver")
@NoArgsConstructor
public class Driver extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_work")
    private Date startWork;

    @Column(name = "birthday")
    private Date birthday;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_driverLicense")
    private DriverLicense driverLicense;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DriverStatus status;

    @ManyToMany(mappedBy = "drivers")
    private List<Order> orders;

}
