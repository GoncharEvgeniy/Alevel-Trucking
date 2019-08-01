package com.alevel.trucking.model.goods;

import com.alevel.trucking.model.order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Table(name = "goods")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "weight")
    private int weight;

    @Column(name = "length")
    private int length;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Column(name = "volume")
    private int volume;

    @ManyToMany(mappedBy = "goods")
    private List<Order> orders;
}
