package com.hcltech.doctorpatientservice.service;

import com.hcltech.doctorpatientservice.dto.DiseaseDTO;
import java.util.List;
import java.util.UUID;

public interface DiseaseService {
    DiseaseDTO createDisease(DiseaseDTO dto);
    DiseaseDTO getDiseaseById(UUID id);
    void deleteDisease(UUID id);

    List<DiseaseDTO> getAllDiseases();
}
