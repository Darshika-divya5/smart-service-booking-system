package com.project.servicebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.servicebooking.dto.UserDTO;
import com.project.servicebooking.entity.User;
import com.project.servicebooking.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return service.saveUser(user);
    }
    
    
   
    @GetMapping
    public List<UserDTO> getUsers() {
        return service.getAllUsers();
    }
    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}
