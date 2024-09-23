package com.example.HealthierU.models;

import com.example.HealthierU.DTOs.PatientDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="Patient")
//@EqualsAndHashCode()
public class PatientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "patientname")
    private String patientName;
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
        this.patientAge = patientDTO.patientAge();
        this.patientBirthDate = patientDTO.patientBirthDate();
        this.patientAddress = patientDTO.patientAddress();
        this.patientPhoneNumber = patientDTO.patientPhoneNumber();
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public LocalDate getPatientBirthDate() {
        return patientBirthDate;
    }

    public void setPatientBirthDate(LocalDate patientBirthDate) {
        this.patientBirthDate = patientBirthDate;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    @Override
    public String toString() {
        return "PatientModel{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", patientAge=" + patientAge +
                ", patientBirthDate=" + patientBirthDate +
                ", patientAddress='" + patientAddress + '\'' +
                ", patientPhoneNumber='" + patientPhoneNumber + '\'' +
                '}';
    }
}
