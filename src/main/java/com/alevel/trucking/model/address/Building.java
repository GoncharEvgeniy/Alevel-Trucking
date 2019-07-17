package com.alevel.trucking.model.address;

import javax.persistence.*;

@Entity
@Table(name = "building")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private int number;

    @OneToOne(mappedBy = "building", cascade = CascadeType.ALL)
    private Address address;
}
