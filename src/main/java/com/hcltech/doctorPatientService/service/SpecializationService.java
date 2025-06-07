package com.hcltech.doctorPatientService.service;

import com.hcltech.doctorPatientService.dao.service.SpecializationDao;
import com.hcltech.doctorPatientService.dto.SpecializationDto;
import com.hcltech.doctorPatientService.model.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {

    @Autowired
    private SpecializationDao specializationDao;

    public List<SpecializationDto> getAll() {
        return null;
    }
    public SpecializationDto getOneById(Integer id){
        return null;
    }
    public SpecializationDto create(SpecializationDto specializationDto){
        return null;
    }
    public SpecializationDto update(SpecializationDto specializationDto){
        return null;
    }
    public void delete(Integer id){

    }
    public SpecializationDto toDto(Specialization specialization){
            return  null;
    }

}
