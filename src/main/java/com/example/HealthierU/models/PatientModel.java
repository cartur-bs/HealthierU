package com.example.HealthierU.models;

import com.example.HealthierU.DTOs.PatientDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="Patient")
public class PatientModel {
    @Id
    @GeneratedValue
    @Column(name = "patientid")
    private UUID patientId;
    @Column(name = "patientname")
    private String patientName;
    @Column(name = "cpf")
    private String CPF;
    @Column(name = "patientage")
    private int patientAge;
    @Column(name = "patientbirthdate")
    private LocalDate patientBirthDate;
    @Column(name = "patientaddress")
    private String patientAddress;
    @Column(name = "patientphonenumber")
    private  String patientPhoneNumber;

    public PatientModel() {
    }

    public PatientModel(PatientDTO patientDTO) {
        this.patientName = patientDTO.patientName();
        this.CPF = patientDTO.cpf();
        this.patientAge = patientDTO.patientAge();
        this.patientBirthDate = patientDTO.patientBirthDate();
        this.patientAddress = patientDTO.patientAddress();
        this.patientPhoneNumber = patientDTO.patientPhoneNumber();
    }

    public String getPatientName() {
        return patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public LocalDate getPatientBirthDate() {
        return patientBirthDate;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public String getCPF() {
        return CPF;
    }

    @Override
    public String toString() {
        return "PatientModel{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientAge=" + patientAge +
                ", patientBirthDate=" + patientBirthDate +
                ", patientAddress='" + patientAddress + '\'' +
                ", patientPhoneNumber='" + patientPhoneNumber + '\'' +
                '}';
    }
}
