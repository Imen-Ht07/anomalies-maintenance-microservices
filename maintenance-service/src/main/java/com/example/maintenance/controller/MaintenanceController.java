package com.example.maintenance.controller;

import com.example.maintenance.entity.Intervention;
import com.example.maintenance.entity.Technicien;
import com.example.maintenance.repository.TechnicienRepository;
import com.example.maintenance.service.InterventionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MaintenanceController {
  private final InterventionService interventionService;
  private final TechnicienRepository technicienRepository;

  @GetMapping("/interventions")
  public List<Intervention> allInterventions() { return interventionService.toutes(); }

  @GetMapping("/interventions/{id}")
  public Intervention byId(@PathVariable Long id) { return interventionService.parId(id); }

  @PostMapping("/techniciens")
  public ResponseEntity<Technicien> createTech(@RequestBody Technicien tech) {
    return ResponseEntity.status(HttpStatus.CREATED).body(technicienRepository.save(tech));
  }

  @GetMapping("/techniciens")
  public List<Technicien> allTech() { return technicienRepository.findAll(); }
}
