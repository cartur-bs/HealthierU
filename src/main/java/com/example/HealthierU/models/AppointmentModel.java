package com.example.HealthierU.models;

import com.example.HealthierU.DTOs.AppointmentDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Appointment")
public class AppointmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointmentid")
    private UUID appointmentId;
    private String service;
    @Column(name = "professionalid")
    private UUID professionalId;
    @Column(name = "patientid")
    private UUID patientId;
    @Column(name = "appointmentdate")
    private LocalDateTime appointmentDate;

    public AppointmentModel() {
    }

    public AppointmentModel(AppointmentDTO appointmentDTO) {
        this.service = appointmentDTO.service();
        this.professionalId = appointmentDTO.professionalId();
        this.patientId = appointmentDTO.patientId();
        this.appointmentDate = appointmentDTO.appointmentDate();
    }

    public String getService() {
        return service;
    }

    public UUID getProfessionalId() {
        return professionalId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    @Override
    public String toString() {
        return "AppointmentModel{" +
                "service='" + service + '\'' +
                ", professionalId=" + professionalId +
                ", patientId=" + patientId +
                ", appointmentDate=" + appointmentDate +
                '}';
    }
}
