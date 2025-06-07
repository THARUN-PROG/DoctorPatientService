package com.hcltech.doctorPatientService.repository;

import com.hcltech.doctorPatientService.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository  extends JpaRepository<Specialization,Integer> {

}
