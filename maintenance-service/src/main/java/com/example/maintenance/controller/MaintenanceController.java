package com.example.maintenance.controller;

import com.example.maintenance.entity.Intervention;
import com.example.maintenance.entity.Technicien;
import com.example.maintenance.repository.InterventionRepository;
import com.example.maintenance.repository.TechnicienRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MaintenanceController {
    private final InterventionRepository interventionRepository;
    private final TechnicienRepository technicienRepository;

    @GetMapping("/interventions")
    public List<Intervention> allInterventions() { return interventionRepository.findAll(); }

    @PostMapping("/techniciens")
    public ResponseEntity<Technicien> createTech(@Valid @RequestBody Technicien t) {
        return ResponseEntity.ok(technicienRepository.save(t));
    }

    @GetMapping("/techniciens")
    public List<Technicien> allTechs() { return technicienRepository.findAll(); }
}
