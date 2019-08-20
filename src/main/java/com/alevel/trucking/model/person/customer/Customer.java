package com.alevel.trucking.model.person.customer;


import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.user.Role;
import com.alevel.trucking.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
@Data
@EqualsAndHashCode(exclude = "orders")
@ToString(exclude = "orders")
@NoArgsConstructor
public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> orders;

    @Builder(builderMethodName = "customerBuilder")
    public Customer(Long id,
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
        this.orders = orders;
    }

    public void addOrder(Order order) {
        if (this.orders == null) {
            this.orders = new HashSet<>();
        }
        this.orders.add(order);
    }
}
