package com.example.back_end.service;

import com.example.back_end.entity.Utilisateur;
import com.example.back_end.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Transactional
    public Utilisateur registerUser(String username, String adress, String email, String password) {
        Utilisateur user = new Utilisateur();
        user.setUsername(username);
        user.setAdress(adress);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));

        // Assigner le rôle par défaut client
        user.setRole(Utilisateur.ERole.client);

        // Vérifier si c'est le premier utilisateur pour qu'il soit admin
        if (userRepository.count() == 0) {
            user.setRole(Utilisateur.ERole.administrateur);
        }

        return userRepository.save(user);
    }
}
