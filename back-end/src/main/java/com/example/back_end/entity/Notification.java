package com.example.back_end.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String message;
    private Date dateEnvoie;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public Notification() {
    }

    public Notification(String message, Date dateEnvoie) {
        this.message = message;
        this.dateEnvoie = dateEnvoie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateEnvoie() {
        return dateEnvoie;
    }

    public void setDateEnvoie(Date dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
