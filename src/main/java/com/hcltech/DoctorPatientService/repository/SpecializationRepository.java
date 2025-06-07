package com.hcltech.DoctorPatientService.repository;

import com.hcltech.DoctorPatientService.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository  extends JpaRepository<Specialization,Integer> {

}
