package com.example.back_end.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilisateurResponse {
    String username;
    String email;
    String role;
    Date dateNaissance;
    String codePostal;
    String phoneNumber;
}
