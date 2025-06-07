package com.hcltech.doctorpatientservice.repository;

import com.hcltech.doctorpatientservice.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
}
