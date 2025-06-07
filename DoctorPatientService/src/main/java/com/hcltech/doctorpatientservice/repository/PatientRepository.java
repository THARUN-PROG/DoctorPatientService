package com.hcltech.doctorpatientservice.repository;

import com.hcltech.doctorpatientservice.entity.Patient;
import com.hcltech.doctorpatientservice.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PatientRepository extends JpaRepository<Patient, Long> {
    list<Patient> findByDoctor(Doctor doctor); //get patiets by doctor

    long countByDoctor(Doctor doctor);  //count no. of patients under doctor
}
