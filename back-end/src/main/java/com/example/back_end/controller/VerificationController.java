package com.example.back_end.controller;

import com.example.back_end.entity.Utilisateur;
import com.example.back_end.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class VerificationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/auth/verify")
    public ResponseEntity<String> verifyEmail(@RequestParam("token") String token) {
        // Récupérez l'utilisateur à partir du token
        Utilisateur utilisateur = userRepository.findByVerificationToken(token);

        if (utilisateur == null) {
            return ResponseEntity.badRequest().body("Invalid verification token");
        }

        utilisateur.setVerified(true);
        utilisateur.setVerificationToken(null);
        userRepository.save(utilisateur);

        return ResponseEntity.ok("Email verified successfully");
    }
}
