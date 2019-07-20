package com.alevel.trucking.model.person.driver;

import com.alevel.trucking.model.person.Person;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "driver")
@NoArgsConstructor
public class Driver extends Person {

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
}
