package com.example.back_end.controller;

import com.example.back_end.dto.CentreResponse;
import com.example.back_end.entity.Centre;
import com.example.back_end.service.CentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/centre")
public class CentreController {

    @Autowired
    private CentreService centreService;

    @GetMapping
    public ResponseEntity<List<CentreResponse>> getAllCentres() {
        List<CentreResponse> centres = centreService.findAllCentres();
        return ResponseEntity.ok(centres);
    }

    @PostMapping
    public ResponseEntity<CentreResponse> createCentre(@RequestBody Centre centre) {
        CentreResponse savedCentre = centreService.saveCentre(centre);
        return ResponseEntity.ok(savedCentre);
    }


    @DeleteMapping("/{centreId}")
    public ResponseEntity<CentreResponse> deleteCentre(@PathVariable Long centreId) {
        CentreResponse deletedCentre = centreService.deleteCentre(centreId);
        if (deletedCentre != null) {
            return ResponseEntity.ok(deletedCentre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{centreId}")
    public ResponseEntity<CentreResponse> updateCentre(@PathVariable Long centreId, @RequestBody Centre centre) {
        CentreResponse updateCentre = centreService.updateCentre(centreId, centre);
        if (updateCentre != null) {
            return ResponseEntity.ok(updateCentre);
        }
        return ResponseEntity.notFound().build();
    }
}
