package com.example.back_end.controller;

import com.example.back_end.entity.Users;
import com.example.back_end.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    // Endpoint for user authentication
    @PostMapping("/authenticate")
    public boolean authenticate(@RequestParam String email, @RequestParam String password) {
        return usersService.authenticate(email, password);
    }

    // Endpoint for user registration
    @PostMapping("/register")
    public Users register(@RequestParam String email, @RequestParam String password, @RequestParam String role) {
        return usersService.register(email, password, role);
    }

    // Endpoint for viewing profile
    @GetMapping("/profile/{userId}")
    public String viewProfile(@PathVariable Long userId) {
        return usersService.viewProfile(userId);
    }
}
