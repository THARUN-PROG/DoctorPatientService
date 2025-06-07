package com.hcltech.DoctorPatientService.service;

import com.hcltech.DoctorPatientService.dao.service.SpecializationDao;
import com.hcltech.DoctorPatientService.dto.SpecializationDto;
import com.hcltech.DoctorPatientService.model.Specialization;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecializationService {

    @Autowired
    private SpecializationDao specializationDao;

    public List<SpecializationDto> getAll() {
        List<Specialization> specializationList = specializationDao.getAll();
        List<SpecializationDto> result = specializationDtoList(specializationList);
        return result;
    }
    public SpecializationDto getOneById(Integer id){
        Specialization specialization = specializationDao.getOneById(id);
        if (specialization==null){
            throw new EntityNotFoundException("No specialization found by Id");
        }
        SpecializationDto result = toDto(specialization);
        return result;
    }
    public SpecializationDto create(SpecializationDto specializationDto){
        Specialization specialization= toEntity(specializationDto);
        Specialization savedSpecialization=  specializationDao.create(specialization);
        SpecializationDto result = toDto(savedSpecialization);

        return  result;
    }
    public SpecializationDto update(SpecializationDto specializationDto){
        Specialization specialization= toEntity(specializationDto);
        Specialization updatedSpecialization=  specializationDao.update(specialization);
        SpecializationDto result = toDto(updatedSpecialization);

        return  result;

    }
    public void delete(Integer id){
        specializationDao.delete(id);
    }

    /* Entity Dto conversions */

    public List<SpecializationDto> specializationDtoList(List<Specialization> specializations){
        return specializations.stream()
                .map(specialization -> toDto(specialization))
                .collect(Collectors.toList());
    }
    public SpecializationDto toDto(Specialization specialization){
        SpecializationDto result = new SpecializationDto();

        result.setId(specialization.getId());
        result.setSpecialization(specialization.getSpecializationName());

        return  result;
    }
    public Specialization toEntity(SpecializationDto specializationDto){
        Specialization result = new Specialization();

        result.setId(specializationDto.getId());
        result.setSpecializationName(specializationDto.getSpecialization());
        return  result;
    }

}
