package com.hcltech.DoctorPatientService.dto.AppointmentDto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentRequestDto {
    private UUID id;
    private String diseasename;
    //private String patient_name;
    private LocalDateTime fromTime;
    private LocalDateTime toTime;
}
