package com.example.back_end.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Rendezvous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateHeure;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public Rendezvous() {
        this.dateHeure = dateHeure;
        this.statut = statut;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    public void addRendezVous(Date dateHeure, String statut, Users user) {
        this.dateHeure = dateHeure;
        this.statut = statut;
        this.user = user;
    }

    public void modifyRendezVous(Date dateHeure, String statut) {
        this.dateHeure = dateHeure;
        this.statut = statut;
    }

    public void cancelRendezVous() {
        this.statut = "Canceled";
    }

    public String viewRendezVous() {
        return "Date and Time: " + this.dateHeure + ", Status: " + this.statut;
    }
}
