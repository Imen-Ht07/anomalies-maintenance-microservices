package com.example.surveillance.controller;

import com.example.surveillance.entity.MesureAnalyse;
import com.example.surveillance.service.MesureAnalyseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mesures")
@RequiredArgsConstructor
public class MesureAnalyseController {
  private final MesureAnalyseService mesureAnalyseService;

  @PostMapping
  public ResponseEntity<MesureAnalyse> enregistrer(@RequestBody MesureAnalyse m) {
    return ResponseEntity.status(HttpStatus.CREATED).body(mesureAnalyseService.enregistrer(m));
  }
}
