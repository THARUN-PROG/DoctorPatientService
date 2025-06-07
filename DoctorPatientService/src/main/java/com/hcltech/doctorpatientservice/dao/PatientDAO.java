package com.hcltech.doctorpatientservice.dao;

import com.hcltech.doctorpatientservice.entity.Doctor;
import com.hcltech.doctorpatientservice.entity.Patient;
import com.hcltech.doctorpatientservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PatientDAO {

    private final PatientRepository patientRepository;

    public Optional<Patient> getById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    public long countByDoctor(Doctor doctor) {
        return patientRepository.countByDoctor(doctor);
    }

    public List<Patient> getByDoctor(Doctor doctor) {
        return patientRepository.findByDoctor(doctor);
    }
}