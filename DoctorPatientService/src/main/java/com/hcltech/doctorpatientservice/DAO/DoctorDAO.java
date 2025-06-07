package com.hcltech.doctorpatientservice.dao;

import com.hcltech.doctorpatientservice.model.Doctor;
import com.hcltech.doctorpatientservice.repository.DoctorRepository;

import java.util.List;

public class DoctorDAO {
    private DoctorRepository doctorRepository;
    public DoctorDAO(DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }
}
