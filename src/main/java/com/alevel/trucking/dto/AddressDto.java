package com.alevel.trucking.dto;

import com.alevel.trucking.model.address.Address;
import com.alevel.trucking.model.address.Building;
import com.alevel.trucking.model.address.City;
import com.alevel.trucking.model.address.Street;

import java.io.Serializable;


public class AddressDto implements Serializable {

    private String  city;

    private String street;

    private int building;

    private String suffix;

    public static Address fromDto(AddressDto addressDto) {
        return Address.builder()
                .city(new City(addressDto.getCity()))
                .street(new Street(addressDto.getStreet()))
                .building(new Building(addressDto.getBuilding(), addressDto.getSuffix()))
                .build();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
