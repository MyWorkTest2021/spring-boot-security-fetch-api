package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String showUsersTable() {
        return "/register";
    }


    @GetMapping("/user")
    public String users(){
        return "user";
    }
}
