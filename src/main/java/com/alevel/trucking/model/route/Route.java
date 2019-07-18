package com.alevel.trucking.model.route;

import com.alevel.trucking.model.address.Address;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "route")
@NoArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_start_address")
    private Address start;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_end_address")
    private Address end;

    @Column(name = "distance")
    private double distance;
}
