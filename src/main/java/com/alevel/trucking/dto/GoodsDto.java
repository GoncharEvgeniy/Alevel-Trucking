package com.alevel.trucking.dto;

import com.alevel.trucking.model.goods.Goods;

import java.io.Serializable;

public class GoodsDto implements Serializable {

    private int weight;

    private int length;

    private int width;

    private int height;

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
