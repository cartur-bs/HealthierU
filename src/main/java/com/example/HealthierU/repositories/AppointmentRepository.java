package com.example.HealthierU.repositories;

import com.example.HealthierU.models.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<AppointmentModel, UUID> {
}
