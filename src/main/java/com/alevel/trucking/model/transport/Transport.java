package com.alevel.trucking.model.transport;

import com.alevel.trucking.model.order.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Entity
@Table(name = "transport")
@Data
@EqualsAndHashCode(exclude = "orders")
@ToString(exclude = "orders")
@NoArgsConstructor
@AllArgsConstructor
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

    @JsonIgnore
    @ManyToMany(mappedBy = "transports")
    private Set<Order> orders;

    @Column(name = "cost_per_one_kilometer")
    private double costPerOneKilometer;

    public void addOrder(Order order) {
        if (this.orders == null) {
            this.orders = new HashSet<>();
        }
        orders.add(order);
    }
}
