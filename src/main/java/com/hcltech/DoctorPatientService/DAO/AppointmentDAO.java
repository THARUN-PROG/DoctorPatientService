package com.hcltech.DoctorPatientService.DAO;

import com.hcltech.DoctorPatientService.DTO.AppointmentDto.AppointmentRequestDto;
import com.hcltech.DoctorPatientService.DTO.AppointmentDto.AppointmentResponseDto;
import com.hcltech.DoctorPatientService.Model.Appointment;
import com.hcltech.DoctorPatientService.Service.AppointmentService;
import org.springframework.boot.ApplicationArguments;
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
