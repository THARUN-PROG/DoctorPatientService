package com.hcltech.DoctorPatientService.repository;

import com.hcltech.DoctorPatientService.model.Appointment;
import com.hcltech.DoctorPatientService.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    Patient findByPatientName(String patientName);
}
