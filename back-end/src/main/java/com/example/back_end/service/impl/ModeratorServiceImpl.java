package com.example.back_end.service.impl;

import com.example.back_end.dto.UtilisateurResponse;
import com.example.back_end.entity.ERole;
import com.example.back_end.entity.Utilisateur;
import com.example.back_end.respository.UserRepository;
import com.example.back_end.service.ModeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModeratorServiceImpl implements ModeratorService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public List<UtilisateurResponse> findAllUsers() {
        List<Utilisateur> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private UtilisateurResponse convertToResponse(Utilisateur user) {
        return UtilisateurResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }

    @Override
    public UtilisateurResponse saveUser(Utilisateur user) {
        user.setRole(ERole.MODERATEUR);
        user.setPassword(encoder.encode(user.getPassword()));
        Utilisateur savedUser = userRepository.save(user);
        return convertToResponse(savedUser);
    }

    @Override
    public UtilisateurResponse deleteUser(Long id) {
        Optional<Utilisateur> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            Utilisateur user = userOptional.get();
            userRepository.deleteById(id);
            return convertToResponse(user);
        }
        return null;
    }

    @Override
    public UtilisateurResponse updateUser(Long id, Utilisateur user) {
        Optional<Utilisateur> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            Utilisateur existingUser = userOptional.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(encoder.encode(user.getPassword()));
            Utilisateur updatedUser = userRepository.save(existingUser);
            return convertToResponse(updatedUser);
        }
        return null;
    }
}
