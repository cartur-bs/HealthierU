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
import java.util.List;

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
    public ResponseEntity<?> newAppointment(@RequestBody @Valid AppointmentDTO appointmentDTO) throws SQLException{
        try{
            AppointmentModel appointmentModel = new AppointmentModel(appointmentDTO);
            if(appointmentModel.toString().isEmpty()){
                throw new SQLException();
            }
            List<AppointmentModel> existingAppointments = appointmentRepository.findByProfessionalId(appointmentDTO.professionalId());
            for(AppointmentModel existingAppointment: existingAppointments){
                if(existingAppointment.getAppointmentDate().equals(appointmentDTO.appointmentDate())){
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("THIS DATE IS NOT AVAILABLE FOR THIS PROFESSIONAL, LET'S TRY AGAIN");
                }
            }
            appointmentRepository.save(appointmentModel);
            return ResponseEntity.ok("NEW APPOINTMENT CREATED");
        }catch (SQLException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR TRYING TO SAVE NEW APPOINTMENT: "+e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("INVALID INPUT: "+e.getMessage());
        }
    }
}
