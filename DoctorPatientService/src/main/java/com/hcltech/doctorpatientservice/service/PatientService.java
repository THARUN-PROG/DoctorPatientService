package com.hcltech.doctorpatientservice.service;

import com.hcltech.doctorpatientservice.dao.PatientDAO;
import com.hcltech.doctorpatientservice.dto.PatientDTO;
import com.hcltech.doctorpatientservice.entity.Doctor;
import com.hcltech.doctorpatientservice.entity.Patient;
import com.hcltech.doctorpatientservice.exception.CustomException;
import com.hcltech.doctorpatientservice.mapper.PatientMapper;
import com.hcltech.doctorpatientservice.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientDAO patientDAO;
    private final DoctorRepository doctorRepository;
    private final PatientMapper patientMapper;

    public List<PatientDTO> getAllPatients() {
        return patientDAO.getAll().stream()
                .map(patientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PatientDTO getPatientById(Long id) {
        Patient patient = patientDAO.getById(id)
                .orElseThrow(() -> new CustomException("Patient not found with ID: " + id));
        return patientMapper.toDTO(patient);
    }

    public PatientDTO createPatient(PatientDTO dto) {
        Patient patient = patientMapper.toEntity(dto);

        if (dto.getDoctorId() != null) {
            Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                    .orElseThrow(() -> new CustomException("Doctor not found with ID: " + dto.getDoctorId()));
            long count = patientDAO.countByDoctor(doctor);
            if (count >= 4) {
                throw new CustomException("Doctor already has maximum 4 patients.");
            }
            patient.setDoctor(doctor);
        }

        return patientMapper.toDTO(patientDAO.save(patient));
    }

    public PatientDTO updatePatient(Long id, PatientDTO dto) {
        Patient existing = patientDAO.getById(id)
                .orElseThrow(() -> new CustomException("Patient not found with ID: " + id));

        existing.setAge(dto.getAge());
        existing.setGender(dto.getGender());
        existing.setBloodGroup(dto.getBloodGroup());

        if (dto.getDoctorId() != null) {
            Doctor newDoctor = doctorRepository.findById(dto.getDoctorId())
                    .orElseThrow(() -> new CustomException("Doctor not found with ID: " + dto.getDoctorId()));

            if (!newDoctor.equals(existing.getDoctor())) {
                long count = patientDAO.countByDoctor(newDoctor);
                if (count >= 4) {
                    throw new CustomException("Doctor already has 4 patients.");
                }
                existing.setDoctor(newDoctor);
            }
        } else {
            existing.setDoctor(null);
        }

        return patientMapper.toDTO(patientDAO.save(existing));
    }

    public void deletePatient(Long id) {
        if (patientDAO.getById(id).isEmpty()) {
            throw new CustomException("Patient not found with ID: " + id);
        }
        patientDAO.delete(id);
    }
}