package com.example.Database.model;

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
    @JoinColumn(name = "donneur_id")
    private Donneur donneur;

    public Rendezvous(Date dateHeure, String statut, Donneur donneur) {
        this.dateHeure = dateHeure;
        this.statut = statut;
        this.donneur = donneur;
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

    public Donneur getDonneur() {
        return donneur;
    }

    public void setDonneur(Donneur donneur) {
        this.donneur = donneur;
    }
}
