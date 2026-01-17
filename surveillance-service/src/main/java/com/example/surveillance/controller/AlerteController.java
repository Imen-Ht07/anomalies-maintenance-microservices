package com.example.surveillance.controller;

import com.example.surveillance.entity.Alerte;
import com.example.surveillance.service.AlerteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertes")
@RequiredArgsConstructor
public class AlerteController {
  private final AlerteService alerteService;

  @PostMapping
  public ResponseEntity<Alerte> creer(@RequestBody Alerte alerte) {
    return ResponseEntity.status(HttpStatus.CREATED).body(alerteService.creerAlerte(alerte));
  }

  @GetMapping
  public List<Alerte> all() { return alerteService.toutes(); }

  @GetMapping("/{id}")
  public Alerte byId(@PathVariable Long id) { return alerteService.parId(id); }
}
