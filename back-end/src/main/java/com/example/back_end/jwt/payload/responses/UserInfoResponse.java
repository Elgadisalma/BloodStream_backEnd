package com.example.back_end.jwt.payload.responses;


import java.util.List;
import java.util.UUID;

public class UserInfoResponse {
    private UUID userId;
    private String username;
    private String email;
    private String adress;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


    public UserInfoResponse(Long id, String username, String email, String adress) {
        super();
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.adress = adress;
    }

}