package com.alevel.trucking.model.goods;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "goods")
@NoArgsConstructor
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
}
