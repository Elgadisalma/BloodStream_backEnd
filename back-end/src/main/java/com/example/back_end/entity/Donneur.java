package com.example.Database.model;

import jakarta.persistence.*;

import java.util.List;

public class Donneur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupeSanguin;
    private String dossierMedical;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "donneur")
    private List<Rendezvous> rendezVousList;

    public Donneur(Long id, String groupeSanguin, String dossierMedical, User user) {
        this.id = id;
        this.groupeSanguin = groupeSanguin;
        this.dossierMedical = dossierMedical;
        this.user = user;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getgroupeSanguin() {
        return groupeSanguin;
    }

    public void setgroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public String getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(String dossierMedical) {
        this.dossierMedical = dossierMedical;
    }

    public List<Rendezvous> getRendezVousList() {
        return rendezVousList;
    }

    public void setRendezVousList(List<Rendezvous> rendezVousList) {
        this.rendezVousList = rendezVousList;
    }
}
