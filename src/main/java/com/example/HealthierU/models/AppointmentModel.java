package com.example.HealthierU.models;

import com.example.HealthierU.DTOs.AppointmentDTO;
import com.example.HealthierU.controllers.PatientController;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

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
    /*@JoinColumn(name = "professional_id", referencedColumnName = "professionalid")
    @Column(name = "professionalmodel")
    private ProfessionalModel professionalModel;

    @JoinColumn(name = "professional_id", referencedColumnName = "professionalid")
    @Column(name = "patientmodel")
    private PatientModel patientModel;*/
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

   public UUID getProfessionalModel() {
        return professionalId;
    }

    public LocalDateTime getappointmentDate() {
        return appointmentDate;
    }

    @Override
    public String toString() {
        return "AppointmentModel{" +
                "service='" + service + '\'' +
               // ", professionalModel=" + professionalModel +
                ", appointmentDate=" + appointmentDate +
                '}';
    }
}
