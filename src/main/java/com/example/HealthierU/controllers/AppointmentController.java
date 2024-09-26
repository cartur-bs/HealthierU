package com.example.HealthierU.controllers;

import com.example.HealthierU.DTOs.AppointmentDTO;
import com.example.HealthierU.models.AppointmentModel;
import com.example.HealthierU.repositories.AppointmentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/appointment")
public class AppointmentController extends SQLException{
    @Autowired
    AppointmentRepository appointmentRepository;

    @GetMapping("get-all")
    public ResponseEntity<?> getAllAppointments() throws SQLException{
        try{
            var allAppointments = appointmentRepository.findAll();
            if(allAppointments.isEmpty()){
                throw new SQLException();
            }
            return ResponseEntity.ok(allAppointments);
        }catch(SQLException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error trying to retrieve patients from DB: " + e.getMessage());
        }
    }
    @PostMapping("/post")
    public ResponseEntity<?> newAppointment(@RequestBody @Valid AppointmentDTO appointmentDTO){
        AppointmentModel appointmentModel = new AppointmentModel(appointmentDTO);
        appointmentRepository.save(appointmentModel);
        System.out.println(appointmentModel);
        return ResponseEntity.ok("NEW APPOINTMENT CREATED");
    }
}
