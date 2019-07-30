package com.alevel.trucking.model.person.driver;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "driver_license")
@NoArgsConstructor
public class DriverLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_of_registration")
    private Date dateOfRegistration;

    @Column(name = "date_of_first_registration")
    private Date dateOfFirstRegistration;

    @Column(name = "validity")
    private Date validity;

    @ElementCollection(targetClass = Category.class)
    @CollectionTable(name = "driver_license_category",
            joinColumns = @JoinColumn(name = "id_driver_license"))
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Set<Category> categorys;

    @OneToOne(mappedBy = "driverLicense")
    private Driver driver;
}
