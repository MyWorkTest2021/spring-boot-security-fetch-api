package com.example.springboot.service;

import com.example.springboot.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User findById(int id);
    User save(User user);
    User update(User user);
    void deleteById(int id);
    User findByUsername(String s);
    User getByName(String name);
}
