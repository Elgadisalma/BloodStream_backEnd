package com.example.back_end.service;

import com.example.back_end.entity.Rendezvous;
import com.example.back_end.entity.Users;
import com.example.back_end.respository.RendezvousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RendezvousService {
    @Autowired
    private RendezvousRepository rendezVousRepository;

    // Method for adding an appointment
    public Rendezvous addRendezVous(Date dateHeure, String statut, Users user) {
        Rendezvous rendezvous = new Rendezvous();
        rendezvous.addRendezVous(dateHeure, statut, user);
        return rendezVousRepository.save(rendezvous);
    }

    // Method for modifying an appointment
    public Rendezvous modifyRendezVous(Long id, Date dateHeure, String statut) {
        Rendezvous rendezVous = rendezVousRepository.findById(id).orElse(null);
        if (rendezVous != null) {
            rendezVous.modifyRendezVous(dateHeure, statut);
            return rendezVousRepository.save(rendezVous);
        }
        return null;
    }

    // Method for canceling an appointment
    public void cancelRendezVous(Long id) {
        Rendezvous rendezVous = rendezVousRepository.findById(id).orElse(null);
        if (rendezVous != null) {
            rendezVous.cancelRendezVous();
            rendezVousRepository.save(rendezVous);
        }
    }

    // Method for viewing appointments by user
    public List<Rendezvous> getRendezVousByUser(Long userId) {
        return rendezVousRepository.findByUserId(userId);
    }
}
