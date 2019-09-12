package com.alevel.trucking.model.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "building")
@NoArgsConstructor
@Getter
@ToString(exclude = {"id", "addresses"})
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private int number;

    @Column(name = "suffix")
    private String suffix;

    @JsonIgnore
    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Building(int number, String suffix) {
        this.number = number;
        this.suffix = suffix;
    }
}
