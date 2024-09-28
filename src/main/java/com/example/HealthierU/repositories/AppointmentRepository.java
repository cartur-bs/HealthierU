package com.example.HealthierU.repositories;

import com.example.HealthierU.models.AppointmentModel;
import com.example.HealthierU.models.ProfessionalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<AppointmentModel, UUID> {
    List<AppointmentModel> findByProfessionalId(UUID professionalId);
}

