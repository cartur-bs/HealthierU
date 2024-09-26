package com.example.HealthierU.DTOs;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentDTO(String service, UUID professionalId, UUID patientId, LocalDateTime appointmentDate) {
}
