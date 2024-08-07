package com.example.back_end.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Don {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Date date;
        private String type;

        @ManyToOne
        @JoinColumn(name = "centre_id")
        private Centre centre;

    public Don(Date date, String type, Centre centre) {
        this.date = date;
        this.type = type;
        this.centre = centre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }
}
