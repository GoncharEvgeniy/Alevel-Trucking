package com.alevel.trucking.dto;

import com.alevel.trucking.model.goods.Goods;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

public class GoodsDto implements Serializable {

    @Positive
    private int weight;

    @PositiveOrZero
    private int length;

    @PositiveOrZero
    private int width;

    @PositiveOrZero
    private int height;

    @PositiveOrZero
    private int volume;

    public static Goods fromDto(GoodsDto goodsDto){
        return Goods.builder()
                .height(goodsDto.getHeight())
                .length(goodsDto.getLength())
                .volume(goodsDto.getVolume())
                .weight(goodsDto.getWeight())
                .width(goodsDto.getWidth())
                .build();
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
