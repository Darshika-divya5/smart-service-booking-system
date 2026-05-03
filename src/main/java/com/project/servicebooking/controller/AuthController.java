package com.project.servicebooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.servicebooking.security.JwtUtil;
import com.project.servicebooking.entity.User;
import com.project.servicebooking.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        // HARDCODE LOGIN
        if (username.equals("admin") && password.equals("1234")) {
            return jwtUtil.generateToken(username, "ADMIN");
        }

        if (username.equals("user") && password.equals("1234")) {
            return jwtUtil.generateToken(username, "USER");
        }

        throw new RuntimeException("Invalid credentials");
    }
   }
