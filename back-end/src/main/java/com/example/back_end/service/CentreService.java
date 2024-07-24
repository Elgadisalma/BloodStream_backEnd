package com.example.back_end.service;

import com.example.back_end.dto.CentreResponse;
import com.example.back_end.entity.Centre;

import java.util.List;

public interface CentreService {

    List<CentreResponse> findAllCentres();

    CentreResponse saveCentre(Centre user);

    CentreResponse deleteCentre(Long id);

    CentreResponse updateCentre(Long id, Centre user);
}
