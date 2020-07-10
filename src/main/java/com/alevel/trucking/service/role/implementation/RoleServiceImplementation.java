package com.alevel.trucking.service.role.implementation;

import com.alevel.trucking.model.user.Role;
import com.alevel.trucking.repository.RoleRepository;
import com.alevel.trucking.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImplementation implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImplementation(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

}
