package com.hcltech.doctorPatientService.controller;


import com.hcltech.doctorPatientService.dto.SpecializationDto;
import com.hcltech.doctorPatientService.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctorPatientService/v1/specializations")
public class SpecializationController {

    @Autowired
    SpecializationService specializationService;

    @GetMapping
    public ResponseEntity<List<SpecializationDto>> getAll(){
        List<SpecializationDto> result = specializationService.getAll();
        if (result==null|| result.isEmpty()){
            throw new RuntimeException("No data");
        }
        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<SpecializationDto> create(SpecializationDto specializationDto){
        specializationService.create(specializationDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<SpecializationDto> getById(@PathVariable Integer id){
        return null;
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        return null;
    }

}
