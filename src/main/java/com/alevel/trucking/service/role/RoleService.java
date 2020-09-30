package com.alevel.trucking.service.role;

import com.alevel.trucking.model.user.Role;

public interface RoleService {

    Role findByName(String name);

    void save(Role role);
}
