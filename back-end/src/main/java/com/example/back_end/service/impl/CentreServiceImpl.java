package com.example.back_end.service.impl;

import com.example.back_end.dto.CentreResponse;
import com.example.back_end.entity.Centre;
import com.example.back_end.entity.Utilisateur;
import com.example.back_end.respository.CentreRepository;
import com.example.back_end.respository.UserRepository;
import com.example.back_end.service.CentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CentreServiceImpl implements CentreService {

    @Autowired
    private CentreRepository centreRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CentreResponse> findAllCentres() {
        List<Centre> centres = centreRepository.findAll();
        return centres.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private CentreResponse convertToResponse(Centre centre) {
        return CentreResponse.builder()
                .name(centre.getName())
                .adress(centre.getAdress())
                .city(centre.getCity())
                .owner(String.valueOf(centre.getOwner().getId()))
                .build();
    }

    @Override
    public CentreResponse saveCentre(Centre centre) {
        Utilisateur owner = userRepository.findById(centre.getOwner().getId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        centre.setOwner(owner);
        Centre savedCentre = centreRepository.save(centre);
        return convertToResponse(savedCentre);
    }

    @Override
    public CentreResponse deleteCentre(Long id) {
        Optional<Centre> centreOptional = centreRepository.findById(id);
        if (centreOptional.isPresent()) {
            Centre centre = centreOptional.get();
            centreRepository.deleteById(id);
            return convertToResponse(centre);
        }
        return null;
    }

    @Override
    public CentreResponse updateCentre(Long id, Centre centre) {
        Optional<Centre> centreOptional = centreRepository.findById(id);
        if (centreOptional.isPresent()) {
            Centre existingCentre = centreOptional.get();
            Utilisateur owner = userRepository.findById(centre.getOwner().getId())
                    .orElseThrow(() -> new RuntimeException("Owner not found"));
            existingCentre.setName(centre.getName());
            existingCentre.setCity(centre.getCity());
            existingCentre.setAdress(centre.getAdress());
            existingCentre.setOwner(owner);
            Centre updatedCentre = centreRepository.save(existingCentre);
            return convertToResponse(updatedCentre);
        }
        return null;
    }
}
