package com.example.back_end.entity;

import jakarta.persistence.*;

@Entity
public class DossierMedicale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maladie;
    private String groupSanguin;
    private String antecedentsDons;
    private String allergies;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public DossierMedicale(String maladie, String groupSanguin, String antecedentsDons, String allergies) {
        this.maladie = maladie;
        this.groupSanguin = groupSanguin;
        this.antecedentsDons = antecedentsDons;
        this.allergies = allergies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaladie() {
        return maladie;
    }

    public void setMaladie(String maladie) {
        this.maladie = maladie;
    }

    public String getGroupSanguin() {
        return groupSanguin;
    }

    public void setGroupSanguin(String groupSanguin) {
        this.groupSanguin = groupSanguin;
    }

    public String getAntecedentsDons() {
        return antecedentsDons;
    }

    public void setAntecedentsDons(String antecedentsDons) {
        this.antecedentsDons = antecedentsDons;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
