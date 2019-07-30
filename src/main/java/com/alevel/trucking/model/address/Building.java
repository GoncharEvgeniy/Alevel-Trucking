package com.alevel.trucking.model.address;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "building")
@NoArgsConstructor
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private int number;

    @Column(name = "suffix")
    private String suffix;

}
