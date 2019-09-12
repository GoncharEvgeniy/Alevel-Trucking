package com.alevel.trucking.dto;


import com.alevel.trucking.model.transport.Transport;
import com.alevel.trucking.model.transport.TransportType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class TransportDto {

    @NotBlank
    private String name;

    @NotBlank
    private TransportType type;

    @NotBlank
    private String licensePlateNumber;

    @NotBlank
    @Positive
    private int loadCapacity;

    @PositiveOrZero
    private int maxLengthOfGoods;

    @PositiveOrZero
    private int maxWidthOfGoods;

    @PositiveOrZero
    private int maxHeightOfGoods;

    @PositiveOrZero
    private int maxVolumeOfGoods;

    @Positive
    private double costPerOneKilometer;

    public static Transport fromDto(TransportDto transportDto) {
        return Transport.builder()
                .name(transportDto.getName())
                .licensePlateNumber(transportDto.getLicensePlateNumber())
                .loadCapacity(transportDto.getLoadCapacity())
                .maxHeightOfGoods(transportDto.getMaxHeightOfGoods())
                .maxLengthOfGoods(transportDto.getMaxLengthOfGoods())
                .maxWidthOfGoods(transportDto.getMaxWidthOfGoods())
                .maxVolumeOfGoods(transportDto.getMaxVolumeOfGoods())
                .type(transportDto.getType())
                .costPerOneKilometer(transportDto.getCostPerOneKilometer())
                .build();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TransportType getType() {
        return type;
    }

    public void setType(TransportType type) {
        this.type = type;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public int getMaxLengthOfGoods() {
        return maxLengthOfGoods;
    }

    public void setMaxLengthOfGoods(int maxLengthOfGoods) {
        this.maxLengthOfGoods = maxLengthOfGoods;
    }

    public int getMaxWidthOfGoods() {
        return maxWidthOfGoods;
    }

    public void setMaxWidthOfGoods(int maxWidthOfGoods) {
        this.maxWidthOfGoods = maxWidthOfGoods;
    }

    public int getMaxHeightOfGoods() {
        return maxHeightOfGoods;
    }

    public void setMaxHeightOfGoods(int maxHeightOfGoods) {
        this.maxHeightOfGoods = maxHeightOfGoods;
    }

    public int getMaxVolumeOfGoods() {
        return maxVolumeOfGoods;
    }

    public void setMaxVolumeOfGoods(int maxVolumeOfGoods) {
        this.maxVolumeOfGoods = maxVolumeOfGoods;
    }

    public double getCostPerOneKilometer() {
        return costPerOneKilometer;
    }

    public void setCostPerOneKilometer(double costPerOneKilometer) {
        this.costPerOneKilometer = costPerOneKilometer;
    }
}
