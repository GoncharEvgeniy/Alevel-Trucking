package com.alevel.trucking.model.person.driver;

import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.user.Role;
import com.alevel.trucking.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "driver")
@Data
@EqualsAndHashCode(exclude = "orders")
@ToString(exclude = "orders")
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

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_driver_license")
    private DriverLicense driverLicense;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DriverStatus status;

    @JsonIgnore
    @ManyToMany(mappedBy = "drivers")
    private Set<Order> orders;

    @Builder(builderMethodName = "managerBuilder")
    public Driver(Long id,
                  Date startWork,
                  Date birthday,
                  DriverLicense driverLicense,
                  DriverStatus status,
                  Set<Order> orders,
                  String password,
                  String username,
                  String email,
                  String firstName,
                  String secondName,
                  String lastName,
                  String phone,
                  Set<Role> roles,
                  boolean isAccountNonExpired,
                  boolean isAccountNonLocked,
                  boolean isCredentialsNonExpired,
                  boolean isEnabled) {
        super(id,
                password,
                username,
                email,
                firstName,
                secondName,
                lastName,
                phone,
                roles,
                isAccountNonExpired,
                isAccountNonLocked,
                isCredentialsNonExpired,
                isEnabled);
        this.startWork = startWork;
        this.birthday = birthday;
        this.driverLicense = driverLicense;
        this.orders = orders;
        this.status = status;
    }

    public void addOrder(Order order) {
        if (this.orders == null) {
            this.orders = new HashSet<>();
        }
        orders.add(order);
    }
}
