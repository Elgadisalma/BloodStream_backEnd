package com.example.back_end.service;

import com.example.back_end.entity.Users;
import com.example.back_end.respository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    // Method for user authentication
    public boolean authenticate(String email, String password) {
        Users user = usersRepository.findByEmail(email);
        return user != null && user.authenticate(email, password);
    }

    // Method for user registration
    public Users register(String email, String password, String role) {
        Users user = new Users();
        user.register(email, password, role);
        return usersRepository.save(user);
    }

    // Method for viewing profile
    public String viewProfile(Long userId) {
        Users user = usersRepository.findById(userId).orElse(null);
        return user != null ? user.viewProfile() : "User not found";
    }

    // Method to find user by ID
    public Optional<Users> findById(Long userId) {
        return usersRepository.findById(userId);
    }

}
