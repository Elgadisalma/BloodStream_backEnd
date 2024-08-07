package com.example.back_end.controller;

import com.example.back_end.entity.Rendezvous;
import com.example.back_end.entity.Users;
import com.example.back_end.service.RendezvousService;
import com.example.back_end.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rendezvous")
public class RendezvousController {
    @Autowired
    private RendezvousService rendezVousService;

    @Autowired
    private UsersService usersService;

    // Endpoint for adding an appointment
    @PostMapping("/add")
    public Rendezvous addRendezVous(@RequestParam Date dateHeure, @RequestParam String statut, @RequestParam Long userId) {
        Optional<Users> userOptional = usersService.findById(userId);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            return rendezVousService.addRendezVous(dateHeure, statut, user);
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    // Endpoint for modifying an appointment
    @PutMapping("/modify/{id}")
    public Rendezvous modifyRendezVous(@PathVariable Long id, @RequestParam Date dateHeure, @RequestParam String statut) {
        return rendezVousService.modifyRendezVous(id, dateHeure, statut);
    }

    // Endpoint for canceling an appointment
    @DeleteMapping("/cancel/{id}")
    public void cancelRendezvous(@PathVariable Long id) {
        rendezVousService.cancelRendezVous(id);
    }

    // Endpoint for viewing appointments by user
    @GetMapping("/user/{userId}")
    public List<Rendezvous> getRendezvousByUser(@PathVariable Long userId) {
        return rendezVousService.getRendezVousByUser(userId);
    }
}

