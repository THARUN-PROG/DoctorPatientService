package com.hcltech.doctorpatientservice.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class DiseaseDTO {
    private UUID disease_id;
    private String disease_name;
    private UUID specialization_id;
}
