package com.hcltech.doctorpatientservice.repository;

import com.hcltech.doctorpatientservice.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface DiseaseRepository extends JpaRepository<Disease, UUID> {
    Optional<Disease> findByDiseaseName(String disease_name);
}
