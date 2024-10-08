package com.example.HealthierU.models;

import com.example.HealthierU.DTOs.ProfessinalDTO;
import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name="Professional")
public class ProfessionalModel {
    @Id
    @GeneratedValue
    @Column(name="professionalid")
    private UUID professionalId;
    @Column(name="professionalname")
    private String professionalName;
    @Column(name="professionalregister")
    private int professionalRegister;
    @Column(name="professionalfield")
    private String professionalField;

    public ProfessionalModel() {
    }

    public ProfessionalModel(ProfessinalDTO professinalDTO) {
        this.professionalName = professinalDTO.professionalName();
        this.professionalRegister = professinalDTO.professionalRegister();
        this.professionalField = professinalDTO.professionalField();
    }

    public UUID getProfessionalId() { return professionalId; }

    public String getProfessionalName() {
        return professionalName;
    }

    public int getProfessionalRegister() {
        return professionalRegister;
    }

    public String getProfessionalField() {
        return professionalField;
    }

    @Override
    public String toString() {
        return "ProfessionalModel{" +
                "professionalId=" + professionalId +
                ", professionalName='" + professionalName + '\'' +
                ", professionalRegister=" + professionalRegister +
                ", professionalField='" + professionalField + '\'' +
                '}';
    }
}
