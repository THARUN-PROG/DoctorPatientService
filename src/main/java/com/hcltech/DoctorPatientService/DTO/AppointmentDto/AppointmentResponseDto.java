package com.hcltech.DoctorPatientService.DTO.AppointmentDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentResponseDto {
    private String patient_name;
    private String doctor_name;
    private String disease_name;
    private Date from_time;
    private Date to_time;
}
