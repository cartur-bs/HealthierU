package com.example.HealthierU.controllers;

import com.example.HealthierU.DTOs.PatientDTO;
import com.example.HealthierU.models.PatientModel;
import com.example.HealthierU.repositories.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController extends SQLException{
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("get-all-patients")
    public ResponseEntity getAllPatients() throws SQLException {
       try{
           var allPatients = patientRepository.findAll();
           if(allPatients.isEmpty()){
               throw new SQLException();
           }
           return ResponseEntity.ok(allPatients);
       }catch(SQLException e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error trying to retrieve patients from DB: " + e.getMessage());
       }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getPatientById(@PathVariable UUID id){
        Optional<PatientModel> patient = Optional.ofNullable(patientRepository.findByPatientId(id));
        if(patient.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PATIENT NOT FOUND");
        }
        return ResponseEntity.ok(patient);
    }

    @PostMapping("post-patient")
    public ResponseEntity createPatient(@RequestBody @Valid PatientDTO patientDTO) throws SQLException{
        try {
            PatientModel patientModel = new PatientModel(patientDTO);
            patientRepository.save(patientModel);
            if(patientModel.toString().isEmpty()){
                throw new SQLException();
            }
            return ResponseEntity.ok().build();
        }catch(SQLException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error trying to save patient: " + e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input");

        }
    }
}
