package com.example.back_end.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
    public class Utilisateur {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID userId;

        private String username;

        private String adress;

        @Column(unique = true)
        private String email;

        private String password;

        @Enumerated(EnumType.STRING)
        @Column(length = 20)
        private ERole role;



    public enum ERole {
        client,
        moderateur,
        administrateur
    }



        public UUID getUserId() {
            return userId;
        }

        public void setUserId(UUID userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAdress() {
            return adress;
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

}
