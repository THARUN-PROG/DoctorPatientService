package com.hcltech.DoctorPatientService.dao;

import com.hcltech.DoctorPatientService.dto.AppointmentDto.AppointmentRequestDto;
import com.hcltech.DoctorPatientService.dto.AppointmentDto.AppointmentResponseDto;
import com.hcltech.DoctorPatientService.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentDAO {
    private final AppointmentService appointmentService;

    public AppointmentDAO(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public AppointmentResponseDto create(AppointmentRequestDto appointmentRequestDto){
        appointmentService.create(appointmentRequestDto);
        return  null;
    }
    public AppointmentResponseDto update(AppointmentRequestDto appointmentRequestDto){
        return null;
    }
    public List<AppointmentResponseDto> getall(){
        return appointmentService.getall();
    }
    public AppointmentResponseDto getById(UUID id){
        return appointmentService.getonebyId(id);
    }
    public void delete(UUID id){
        appointmentService.delete(id);
    }
}
