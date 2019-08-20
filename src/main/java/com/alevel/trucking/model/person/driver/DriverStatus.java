package com.alevel.trucking.model.person.driver;

import java.io.Serializable;

public enum DriverStatus implements Serializable {
    IN_ROUTE,
    IN_BOX;

    @Override
    public String toString() {
        return name();
    }
}
