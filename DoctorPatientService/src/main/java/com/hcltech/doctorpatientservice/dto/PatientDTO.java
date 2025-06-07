package com.hcltech.doctorpatientservice.dto;

import com.hcltech.doctorpatientservice.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgumentConstructor
@AllArgumentConstructor
@Data
public class PatientDTO {
    private Long patientId;
    private int age;
    private String bloodGroup;
    private Gender gender;
    private Long doctorId;
}
