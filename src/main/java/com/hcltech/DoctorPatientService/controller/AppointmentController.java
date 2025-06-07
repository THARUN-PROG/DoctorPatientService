package com.hcltech.DoctorPatientService.controller;

import com.hcltech.DoctorPatientService.dao.AppointmentDAO;
import com.hcltech.DoctorPatientService.dto.AppointmentDto.AppointmentRequestDto;
import com.hcltech.DoctorPatientService.dto.AppointmentDto.AppointmentResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/api/appointment")
public class AppointmentController {
    private final AppointmentDAO appointmentDAO;

    public AppointmentController(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }
    @PostMapping
    public AppointmentResponseDto create(@RequestBody AppointmentRequestDto appointmentRequestDto){
        return appointmentDAO.create(appointmentRequestDto);
    }
    @PutMapping
    public AppointmentResponseDto update(AppointmentRequestDto appointmentRequestDto){
        return appointmentDAO.update(appointmentRequestDto);
    }
    @GetMapping
    public List<AppointmentResponseDto> getall(){
        return appointmentDAO.getall();
    }
    @GetMapping("/{id}")
    public AppointmentResponseDto getbyId(@PathVariable("id") UUID id){
        return appointmentDAO.getById(id);
    }
    @DeleteMapping
    public void delete(UUID id){
         appointmentDAO.delete(id);
    }
}
