package com.alevel.trucking.model.address;

import javax.persistence.*;

@Entity
@Table(name = "street")
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "street", cascade = CascadeType.ALL)
    private Address address;
}
