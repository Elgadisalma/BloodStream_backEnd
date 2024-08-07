package com.example.back_end.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;

    @OneToOne(mappedBy = "user")
    private DossierMedicale dossierMedicale;

    @OneToMany(mappedBy = "user")
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "user")
    private Set<Rendezvous> rendezVous;

    public Users() {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Additional methods for authentication, registration, and viewing profile
    public boolean authenticate(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void register(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String viewProfile() {
        return "Email: " + this.email + ", Role: " + this.role;
    }
}
