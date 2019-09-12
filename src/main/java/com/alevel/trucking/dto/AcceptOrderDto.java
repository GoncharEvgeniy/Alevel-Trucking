package com.alevel.trucking.dto;

import java.util.ArrayList;
import java.util.List;

public class AcceptOrderDto {

    private List<Long> transportsId = new ArrayList<>();

    private List<Long> driversId = new ArrayList<>();

    public List<Long> getTransportsId() {
        return transportsId;
    }

    public void setTransportsId(List<Long> transportsId) {
        this.transportsId = transportsId;
    }

    public List<Long> getDriversId() {
        return driversId;
    }

    public void setDriversId(List<Long> driversId) {
        this.driversId = driversId;
    }
}
