package com.example.back_end.controller;

import com.example.back_end.entity.Don;
import com.example.back_end.service.DonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/don")
public class DonController {
    @Autowired
    private DonService donService;

    @PostMapping
    public Don ajouterDon(@RequestBody Don don) {
        return donService.ajouterDon(don);
    }
    @GetMapping
    public List<Don> afficherDons(){
        return donService.afficherDons();

    }
    @GetMapping("/user/{userId}")
    public List<Don> afficherDonsParUtilisateur(@PathVariable Long userId) {
        return donService.afficherDonsParUtilisateur(userId);
    }

}
