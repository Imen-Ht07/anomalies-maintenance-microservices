package com.example.surveillance.controller;

import com.example.surveillance.entity.Alerte;
import com.example.surveillance.repository.AlerteRepository;
import com.example.surveillance.service.AlerteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertes")
@RequiredArgsConstructor
public class AlerteController {
    private final AlerteRepository alerteRepository;
    private final AlerteService alerteService;

    @GetMapping
    public List<Alerte> all() { return alerteRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Alerte> byId(@PathVariable Long id) {
        return alerteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alerte> create(@Valid @RequestBody Alerte alerte) {
        return ResponseEntity.ok(alerteService.create(alerte));
    }
}
