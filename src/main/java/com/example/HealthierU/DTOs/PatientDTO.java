package com.example.HealthierU.DTOs;

import java.time.LocalDate;

public record PatientDTO(String patientName, int patientAge, LocalDate patientBirthDate, String patientAddress, String patientPhoneNumber) {
}
