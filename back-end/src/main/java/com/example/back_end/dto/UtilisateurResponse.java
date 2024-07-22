package com.example.back_end.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilisateurResponse {
    String username;
    String email;
    String role;

}
