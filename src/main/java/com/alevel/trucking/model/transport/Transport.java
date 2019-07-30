package com.alevel.trucking.model.transport;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "transport")
@NoArgsConstructor
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TransportType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TransportStatus status;

    @Column(name = "license_plate_number")
    private String licensePlateNumber;

    @Column(name = "load_capacity")
    private int loadCapacity;

    @Column(name = "max_length_of_goods")
    private int maxLengthOfGoods;

    @Column(name = "max_width_of_goods")
    private int maxWidthOfGoods;

    @Column(name = "max_height_of_goods")
    private int maxHeightOfGoods;

    @Column(name = "max_volume_of_goods")
    private int maxVolumeOfGoods;
}