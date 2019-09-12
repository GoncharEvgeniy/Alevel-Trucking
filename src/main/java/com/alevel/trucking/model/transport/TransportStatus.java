package com.alevel.trucking.model.transport;

public enum TransportStatus {
    IN_BOX,
    IN_ROUTE,
    IN_REPEIR;

    @Override
    public String toString() {
        return name();
    }
}
