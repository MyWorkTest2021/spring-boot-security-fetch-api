package com.example.springboot.controller;

import com.example.springboot.entity.Role;
import com.example.springboot.entity.User;
import com.example.springboot.service.RoleService;
import com.example.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/users")
public class UserRestController {

    private final UserService userService;
    private final RoleService roleService;

    public UserRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<User>> getAll() {
        try{
            System.out.println("ok");
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/user")
    @CrossOrigin
    public ResponseEntity<User> getById(Principal principal) {
        try{
            return new ResponseEntity<>(userService.getByName(principal.getName()), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping
    @CrossOrigin
    public ResponseEntity<User> add(@RequestBody User user) {

        try{

            Set<Role> rolesFromDb = new HashSet<>();
            rolesFromDb.add(roleService.getRoleByName("Role_USER"));
            User userObj = new User();
            userObj.setName(user.getName());
            userObj.setEmail(user.getEmail());
            userObj.setAge(user.getAge());
            userObj.setPhone(user.getPhone());
            userObj.setPassword(user.getPassword());
            userObj.setRoles(rolesFromDb);

            return new ResponseEntity<>(userService.save(userObj), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping
    @CrossOrigin
    public ResponseEntity<User> update(@RequestBody User user) {
        try{
            return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{userId}")
    @CrossOrigin
    public ResponseEntity update(@PathVariable("userId") int employeeId) {
        try{
            userService.deleteById(employeeId);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
