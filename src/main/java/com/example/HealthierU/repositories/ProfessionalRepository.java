package com.example.HealthierU.repositories;

import com.example.HealthierU.models.ProfessionalModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfessionalRepository extends JpaRepository<ProfessionalModel, UUID> {
}
