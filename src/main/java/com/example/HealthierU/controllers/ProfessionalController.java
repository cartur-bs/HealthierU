package com.example.HealthierU.controllers;

import com.example.HealthierU.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professional")
public class ProfessionalController {
    @Autowired
    ProfessionalRepository professionalRepository;
    @GetMapping("/get-all")
    public ResponseEntity getAllProfessionals(){
        var allProfessionals = professionalRepository.findAll();
        return ResponseEntity.ok("deu certo");
    }
}
