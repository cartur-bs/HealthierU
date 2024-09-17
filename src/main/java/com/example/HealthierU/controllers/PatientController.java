package com.example.HealthierU.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/patient")
public class PatientController {
    @GetMapping(path = "/get")
    public ResponseEntity getPatient(){
        return ResponseEntity.ok("deu certo");
    }
}
