package com.hcltech.DoctorPatientService.dao.service;

import com.hcltech.DoctorPatientService.model.Specialization;
import com.hcltech.DoctorPatientService.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SpecializationDao {

    @Autowired
    SpecializationRepository specializationRepository;

    public List<Specialization> getAll(){
        return specializationRepository.findAll();
    }
    public Specialization getOneById(Integer id){
        return specializationRepository.getById(id);
    }
    public Specialization create(Specialization specialization){
        return specializationRepository.save(specialization);
    }
    public Specialization update(Specialization specialization){
        Optional<Specialization> findById = specializationRepository.findById(specialization.getId());

        if (findById.isPresent()){
            Specialization existingSpecialization =findById.get();

            existingSpecialization.setSpecializationName(specialization.getSpecializationName());
            return  specializationRepository.save(existingSpecialization);
        }else {
            return null;
        }

    }
    public  void delete(Integer id){
        specializationRepository.deleteById(id);
    }


}
