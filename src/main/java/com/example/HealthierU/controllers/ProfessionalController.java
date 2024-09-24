package com.example.HealthierU.controllers;

import com.example.HealthierU.DTOs.ProfessinalDTO;
import com.example.HealthierU.models.ProfessionalModel;
import com.example.HealthierU.repositories.ProfessionalRepository;
import jakarta.validation.Valid;
import org.hibernate.annotations.processing.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/professional")
public class ProfessionalController extends SQLException {
    @Autowired
    ProfessionalRepository professionalRepository;
    @GetMapping("/get-all")
    public ResponseEntity getAllProfessionals() throws SQLException{
        var allProfessionals = professionalRepository.findAll();
        return ResponseEntity.ok("deu certo");
    }

    @PostMapping("/new-professional")
    public ResponseEntity newProfessional(@RequestBody @Valid ProfessinalDTO professinalDTO){
       try{
           ProfessionalModel professionalModel = new ProfessionalModel(professinalDTO);
           professionalRepository.save(professionalModel);
           if(professionalModel.toString().isEmpty()){
               throw new SQLException();
           }
           return ResponseEntity.ok().build();
       }catch (SQLException e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR SAVING DATA"+e.getMessage());
       }

    }

}
