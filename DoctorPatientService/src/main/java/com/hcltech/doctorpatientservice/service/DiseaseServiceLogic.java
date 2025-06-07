package com.hcltech.doctorpatientservice.service;

import com.hcltech.doctorpatientservice.dto.DiseaseDTO;
import com.hcltech.doctorpatientservice.model.Disease;
import com.hcltech.doctorpatientservice.model.Specialization;
import com.hcltech.doctorpatientservice.exception.ResourceNotFoundException;
import com.hcltech.doctorpatientservice.repository.DiseaseRepository;
import com.hcltech.doctorpatientservice.repository.SpecializationRepository;
import com.hcltech.doctorpatientservice.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

public class DiseaseServiceLogic implements DiseaseService{
    private final DiseaseRepository diseaseRepository;
    private final SpecializationRepository specializationRepository;
    private final ModelMapper modelMapper;

    public DiseaseServiceLogic(DiseaseRepository diseaseRepository, SpecializationRepository specializationRepository, ModelMapper modelMapper) {
        this.diseaseRepository = diseaseRepository;
        this.specializationRepository = specializationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DiseaseDTO createDisease(DiseaseDTO dto){
        Specialization specialization = (Specialization) specializationRepository.findById(dto.getSpecialization_id()).orElseThrow(() -> new ResourceNotFoundException("Specialization Not Found"));

        Disease disease = new Disease();
        disease.setDisease_name(dto.getDisease_name());
        disease.setSpecialization(specialization);

        Disease saved = diseaseRepository.save(disease);
        return convertToDto(saved);
    }

    @Override
    public DiseaseDTO getDiseaseById(UUID id){
        Disease disease = diseaseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Disease not found"));
        return convertToDto(disease);
    }

    @Override
    public List<DiseaseDTO> getAllDiseases() {
        return diseaseRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDisease(UUID id){
        if(!diseaseRepository.existsById(id)){
            throw new ResourceNotFoundException("Disease Not Found");
        }
        diseaseRepository.deleteById(id);
    }

    private DiseaseDTO convertToDto(Disease disease){
        DiseaseDTO dto = new DiseaseDTO();
        dto.setDisease_id(disease.getDisease_id());
        dto.setDisease_name(disease.getDisease_name());
        dto.setSpecialization_id(disease.getSpecialization().getId());
        return dto;
    }
}
