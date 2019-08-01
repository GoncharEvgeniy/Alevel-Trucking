package com.alevel.trucking.model.address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "building")
@NoArgsConstructor
@Getter
@ToString(exclude = "id")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private int number;

    @Column(name = "suffix")
    private String suffix;

    public Building(int number, String suffix) {
        this.number = number;
        this.suffix = suffix;
    }
}
