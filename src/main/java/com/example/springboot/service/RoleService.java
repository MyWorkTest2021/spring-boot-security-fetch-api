package com.example.springboot.service;

import com.example.springboot.entity.Role;

import java.util.List;

public interface RoleService {

    List<String> getRoleNamesToList();

    Role getRoleByName(String name);

    List<Role> getAllRoles();
}
