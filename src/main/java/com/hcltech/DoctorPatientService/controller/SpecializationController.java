package com.hcltech.DoctorPatientService.controller;


import com.hcltech.DoctorPatientService.dto.SpecializationDto;
import com.hcltech.DoctorPatientService.service.SpecializationService;
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
    @GetMapping("/{id}")
    public ResponseEntity<SpecializationDto> getById(@PathVariable("id") Integer id){
        SpecializationDto result = specializationService.getOneById(id);
        if (result==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<SpecializationDto> create(SpecializationDto specializationDto){
        SpecializationDto result = specializationService.create(specializationDto);
        if (result==null){
            return ResponseEntity.internalServerError().build();
        }
        return new ResponseEntity(result,HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<SpecializationDto> update(SpecializationDto specializationDto){
        SpecializationDto result = specializationService.update(specializationDto);
        if (result==null){
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(result);

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        specializationService.delete(id);
        return null;
    }

}
