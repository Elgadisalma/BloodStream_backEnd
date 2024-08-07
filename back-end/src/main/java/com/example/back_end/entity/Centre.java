package com.example.back_end.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String localisation;
    private int stock;

    @OneToMany(mappedBy = "centre")
    private List<Don> dons;

    public Centre(String name, String address, String localisation) {
        this.name = name;
        this.address = address;
        this.localisation = localisation;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Don> getDons() {
        return dons;
    }

    public void setDons(List<Don> dons) {
        this.dons = dons;
    }
}
