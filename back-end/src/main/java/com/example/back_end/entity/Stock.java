package com.example.back_end.entity;

import jakarta.persistence.*;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Typesang;
    private int Quantity;
    @ManyToOne
    @JoinColumn(name = "centre_id")
    private Centre centre;

    public Stock() {
    }

    public Stock(String typesang, int quantity, Centre centre) {
        Typesang = typesang;
        Quantity = quantity;
        this.centre = centre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypesang() {
        return Typesang;
    }

    public void setTypesang(String typesang) {
        Typesang = typesang;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }
}
