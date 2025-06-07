package com.hcltech.doctorpatientservice.controller;

import com.hcltech.doctorpatientservice.dto.DiseaseDTO;
import com.hcltech.doctorpatientservice.service.DiseaseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/diseases")
@RequiredArgsConstructor
@Tag(name="Disease Controller", description = "API's for managing diseases")

public class DiseaseController {

    private final DiseaseService diseaseService;

    @PostMapping
    public ResponseEntity<DiseaseDTO> create(@Valid @RequestBody DiseaseDTO dto){
        return ResponseEntity.ok(diseaseService.createDisease(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiseaseDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(diseaseService.getDiseaseById(id));
    }

    @GetMapping
    public ResponseEntity<List<DiseaseDTO>> getAll() {
        return ResponseEntity.ok(diseaseService.getAllDiseases());
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        diseaseService.deleteDisease(id);
        return ResponseEntity.noContent().build();
    }
}
