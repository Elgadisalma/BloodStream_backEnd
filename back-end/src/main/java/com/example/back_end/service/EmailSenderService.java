package com.example.back_end.service;

import com.example.back_end.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(Utilisateur utilisateur) {
        String token = utilisateur.getVerificationToken();
        String verificationLink = "http://localhost:8080/api/auth/verify?token=" + token;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(utilisateur.getEmail());
        message.setFrom("alahcen2000@gmail.com");
        message.setSubject("Email Verification");
        message.setText("Please click the following link to verify your email: " + verificationLink);

        mailSender.send(message);
        System.out.println("Verification email sent");
    }
}
