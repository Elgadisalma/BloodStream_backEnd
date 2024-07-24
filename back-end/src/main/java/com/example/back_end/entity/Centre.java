package com.example.back_end.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Size(min = 2, message = "Name cannot be empty")
    private String name;

    @Column(unique = true)
    @Size(min = 10, message = "Address must be at least 10 characters long")
    private String adress;

    @Size(min = 3, message = "City must be at least 3 characters long")
    private String city;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Utilisateur owner;

    public Centre() {
    }

    public Centre(String name, String address, String city) {
        this.name = name;
        this.adress = address;
        this.city = city;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String address) {
        this.adress = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Utilisateur getOwner() {
        return owner;
    }

    public void setOwner(Utilisateur owner) {
        this.owner = owner;
    }
}
