package com.example.HealthierU.repositories;

import com.example.HealthierU.models.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<PatientModel, UUID> {
}
