package com.hcltech.DoctorPatientService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    Integer id;
    @Column(name = "specialization_name",nullable = false,length = 25)
    String specializationName;

}
