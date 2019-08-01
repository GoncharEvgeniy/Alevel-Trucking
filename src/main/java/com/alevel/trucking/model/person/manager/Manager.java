package com.alevel.trucking.model.person.manager;

import com.alevel.trucking.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "manager")
@Data
@NoArgsConstructor
public class Manager extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_work")
    private Date startWork;

    @Column(name = "birthday")
    private Date birthday;
}
