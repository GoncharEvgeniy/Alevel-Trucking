package com.alevel.trucking.model.person.manager;

import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.user.Role;
import com.alevel.trucking.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "manager")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "orders")
@ToString(exclude = "orders")
public class Manager extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_work")
    private Date startWork;

    @Column(name = "birthday")
    private Date birthday;

    @JsonIgnore
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private Set<Order> orders;

    @Builder(builderMethodName = "managerBuilder")
    public Manager(Long id,
                   Date startWork,
                   Date birthday,
                   String password,
                   String username,
                   String email,
                   String firstName,
                   String secondName,
                   String lastName,
                   String phone,
                   Role role,
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
                role,
                isAccountNonExpired,
                isAccountNonLocked,
                isCredentialsNonExpired,
                isEnabled);
        this.startWork = startWork;
        this.birthday = birthday;
    }
}
