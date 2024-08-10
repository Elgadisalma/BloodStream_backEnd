package com.example.back_end.service;

import com.example.back_end.entity.Don;
import com.example.back_end.respository.DonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DonService {
    @Autowired
    private DonRepository donRepository;

    public Don ajouterDon(Don don) {
        return donRepository.save(don);
    }

    public List<Don> afficherDons() {
        return donRepository.findAll();
    }

    public List<Don> afficherDonsParUtilisateur(Long userId) {
        return donRepository.findByUserId(userId);
    }
    public int countDonsParUtilisateur(Long userId) {
        return donRepository.findByUserId(userId).size();
    }
}
