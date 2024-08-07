package com.example.back_end.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser oidcUser) {
        model.addAttribute("user", oidcUser);
        return "home";
    }
}
