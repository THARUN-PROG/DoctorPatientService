package com.hcltech.doctorpatientservice.dto.doctordto;

import com.hcltech.doctorpatientservice.model.Appointment;
import com.hcltech.doctorpatientservice.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponseDto {
    private UUID doctorId;
    private String name;
    private String experience;
    private String specialist;
    private List<Appointment> appointments;
}
