package com.hcltech.doctorpatientservice.controller;

import com.hcltech.doctorpatientservice.entity.Patient;
import com.hcltech.doctorpatientservice.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/patients")


public class PatientController {
    @Autowired
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> CreatePatient(@RequestBody Patient patient){
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    //get a single patient by ID
    @GetMappping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
            return ResponseEntity.ok(patientService.getPatientById(id));
        }

        // Update a patient
        @PutMapping("/{id}")
        public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
            return ResponseEntity.ok(patientService.updatePatient(id, patient));
        }

        // Delete a patient
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
            patientService.deletePatient(id);
            return ResponseEntity.noContent().build();
        }

        // Assign a doctor to a patient
        @PutMapping("/{patientId}/assign-doctor/{doctorId}")
        public ResponseEntity<Patient> assignDoctor(@PathVariable Long patientId, @PathVariable Long doctorId) {
            return ResponseEntity.ok(patientService.assignDoctorToPatient(patientId, doctorId));
        }

        // Remove the doctor from a patient
        @PutMapping("/{patientId}/remove-doctor")
        public ResponseEntity<Patient> removeDoctor(@PathVariable Long patientId) {
            return ResponseEntity.ok(patientService.removeDoctorFromPatient(patientId));
        }
    }
    }
}
