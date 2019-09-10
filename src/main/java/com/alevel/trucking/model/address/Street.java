package com.alevel.trucking.model.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "street")
@NoArgsConstructor
@Getter
@ToString(exclude = {"id", "addresses"})
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "street", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Street(String name) {
        this.name = name;
    }

 }
