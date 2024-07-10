package com.example.back_end.service;

import com.example.back_end.entity.ERole;
import com.example.back_end.entity.Utilisateur;
import com.example.back_end.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Transactional
    public Utilisateur registerUser(String username, String email, String password) {
        Utilisateur user = new Utilisateur();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));

        // Assigner le rôle par défaut
        user.setRole(ERole.CLIENT);

        return userRepository.save(user);
    }
}