package com.example.back_end.service;

import com.example.back_end.entity.ERole;
import com.example.back_end.entity.Utilisateur;
import com.example.back_end.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    public Utilisateur createUtilisateur(Utilisateur user) {
        user.setRole(ERole.MODERATEUR);
        return userRepository.save(user);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return userRepository.findAll();
    }

    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateurDetails) {
        Utilisateur utilisateur = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur not found"));
        utilisateur.setUsername(utilisateurDetails.getUsername());
        utilisateur.setEmail(utilisateurDetails.getEmail());
        utilisateur.setPassword(utilisateurDetails.getPassword());
        return userRepository.save(utilisateur);
    }

    public void deleteUtilisateur(Long id) {
        userRepository.deleteById(id);
    }
}