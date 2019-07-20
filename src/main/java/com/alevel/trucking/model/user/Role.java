package com.alevel.trucking.model.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    CUSTOMER,
    MANAGER,
    DRIVER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
