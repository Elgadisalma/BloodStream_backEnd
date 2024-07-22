package com.example.back_end.service;

import com.example.back_end.dto.UtilisateurResponse;
import com.example.back_end.entity.Utilisateur;

import java.util.List;

public interface ModeratorService {

    List<UtilisateurResponse> findAllUsers();

    UtilisateurResponse saveUser(Utilisateur user);

    UtilisateurResponse deleteUser(Long id);

    UtilisateurResponse updateUser(Long id, Utilisateur user);
}
