package com.alevel.trucking.model.transport;

import java.io.Serializable;

public enum TransportType implements Serializable {
    CONTAINER,
    COVERED,
    EVACUATOR,
    OPEN,
    TANK;

    @Override
    public String toString() {
        return name();
    }
}
