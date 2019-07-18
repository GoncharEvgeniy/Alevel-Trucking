package com.alevel.trucking.model.address;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="city")
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

}
