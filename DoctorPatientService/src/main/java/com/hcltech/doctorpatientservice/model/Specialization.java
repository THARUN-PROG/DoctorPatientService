package com.hcltech.doctorpatientservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Specialization {

    @Id
    private UUID specialization_id;

    private String specialization_name;

    public UUID getId() {

 return specialization_id;

    }
}
