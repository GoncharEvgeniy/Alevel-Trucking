package com.alevel.trucking.model.address;

import javax.persistence.*;

@Entity
@Table(name ="city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "city", cascade = CascadeType.ALL)
    private Address address;
}
