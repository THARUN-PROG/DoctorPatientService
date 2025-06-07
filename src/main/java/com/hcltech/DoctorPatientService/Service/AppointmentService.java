package com.hcltech.DoctorPatientService.Service;

import com.hcltech.DoctorPatientService.DTO.AppointmentDto.AppointmentRequestDto;
import com.hcltech.DoctorPatientService.DTO.AppointmentDto.AppointmentResponseDto;
import com.hcltech.DoctorPatientService.Model.Appointment;
import com.hcltech.DoctorPatientService.Repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentRequestDto create(AppointmentRequestDto appointmentRequestDto){
        Appointment appointment=toEntity(appointmentRequestDto);

        return  null;
    }
    public AppointmentRequestDto update(){
        return  null;
    }
    public List<AppointmentResponseDto> getall(){
        List<Appointment> appointments=appointmentRepository.findAll();
        List<AppointmentResponseDto> result=toDto(appointments);
        return result;
    }
    public AppointmentResponseDto getonebyId(UUID id){
       Appointment appointment= appointmentRepository.findById(id)
               .orElseThrow(()->new EntityNotFoundException("Entity Not found"));
       AppointmentResponseDto result=toDto(appointment);
       return result;
    }
    public void delete(UUID id){
        appointmentRepository.deleteById(id);
    }
    private List<AppointmentResponseDto> toDto(List<Appointment> appointments){
        return appointments.stream()
                .map(appointment -> toDto(appointment))
                .toList();

    }
    private AppointmentResponseDto toDto(Appointment appointment){
        AppointmentResponseDto appointmentResponseDto=new AppointmentResponseDto();
        appointmentResponseDto.setDisease_name(appointment.getDiseaseName());
        //appointmentResponseDto.setDoctor_name(appointment.getDoctor().getName());
        appointmentResponseDto.setFrom_time(appointment.getFromTime());
        appointmentResponseDto.setTo_time(appointment.getToTime());
        return appointmentResponseDto;
    }
    private Appointment toEntity(AppointmentRequestDto appointmentRequestDto){
        Appointment appointment=new Appointment();
        appointment.setDiseaseName(appointmentRequestDto.getDiseasename());
        appointment.setStatus(Appointment.Status.SCHEDULED);
        //appointment.setPatient(appointmentRepository.findByPatientName(appointmentRequestDto.getPatient_name()));
        //need to be implemented
        // appointment.setDoctor();
        //from time
        //to time
        return appointment;
    }

}
