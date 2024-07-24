package com.example.back_end.controller;

import com.example.back_end.dto.UtilisateurResponse;
import com.example.back_end.entity.ERole;
import com.example.back_end.entity.Utilisateur;
import com.example.back_end.service.ModeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moderator")
public class UtilisateurController {

    @Autowired
    private ModeratorService moderatorService;

    @GetMapping
    public ResponseEntity<List<UtilisateurResponse>> getAllUsers() {
        List<UtilisateurResponse> users = moderatorService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UtilisateurResponse> createUser(@RequestBody Utilisateur user) {
        user.setRole(ERole.MODERATEUR);
        UtilisateurResponse savedUser = moderatorService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<UtilisateurResponse> deleteUser(@PathVariable Long userId) {
        UtilisateurResponse deletedUser = moderatorService.deleteUser(userId);
        if (deletedUser != null) {
            return ResponseEntity.ok(deletedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UtilisateurResponse> updateUser(@PathVariable Long userId, @RequestBody Utilisateur user) {
        UtilisateurResponse updateUser = moderatorService.updateUser(userId, user);
        if (updateUser != null) {
            return ResponseEntity.ok(updateUser);
        }
        return ResponseEntity.notFound().build();
    }
}
