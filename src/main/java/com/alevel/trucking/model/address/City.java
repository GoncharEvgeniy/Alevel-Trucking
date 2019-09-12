package com.alevel.trucking.model.address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "city")
@NoArgsConstructor
@Getter
@ToString(exclude = "id")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public City(String name) {
        this.name = name;
    }
}
