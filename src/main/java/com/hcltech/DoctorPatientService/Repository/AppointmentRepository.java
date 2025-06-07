package com.hcltech.DoctorPatientService.Repository;

import com.hcltech.DoctorPatientService.Model.Appointment;
import com.hcltech.DoctorPatientService.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    Patient findByPatientName(String patientName);
}
