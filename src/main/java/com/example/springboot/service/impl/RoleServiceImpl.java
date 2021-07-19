package com.example.springboot.service.impl;

import com.example.springboot.entity.Role;
import com.example.springboot.repository.RoleRepository;
import com.example.springboot.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<String> getRoleNamesToList() {
        return roleRepository.getRoleNamesToList();
    }

    @Override
    public Role getRoleByName(String name) {

        List<Role> roles= getAllRoles();
        return roles.stream().filter(x -> x.getRole().equals(name)).findAny().orElse(null);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
