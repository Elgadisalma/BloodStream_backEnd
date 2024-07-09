package com.example.back_end.jwt.payload.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequest {
    @NotBlank
    @Size(min = 11, max = 60)
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}