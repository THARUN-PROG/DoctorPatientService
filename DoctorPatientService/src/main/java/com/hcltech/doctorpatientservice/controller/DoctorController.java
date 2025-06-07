package com.hcltech.doctorpatientservice.controller;

import com.hcltech.doctorpatientservice.model.Doctor;
import com.hcltech.doctorpatientservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/doctor")
public class DoctorController {
    private DoctorService doctorService;
    @Autowired
    private DoctorController (DoctorService doctorService){
        this.doctorService=doctorService;
    }
    @GetMapping
    public ResponseEntity<List<Doctor>> getAll(){
        List<Doctor> doctors= doctorService.getAll();
        return ResponseEntity.ok(doctors);
    }
}
