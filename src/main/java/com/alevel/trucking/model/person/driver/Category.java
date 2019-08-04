package com.alevel.trucking.model.person.driver;

import java.io.Serializable;

public enum Category implements Serializable {
    A, AM, A1,
    B, B1, BE,
    C, C1, CE, C1E,
    D, D1, DE, D1E,
    TB, TM;

    @Override
    public String toString() {
        return name();
    }
}
