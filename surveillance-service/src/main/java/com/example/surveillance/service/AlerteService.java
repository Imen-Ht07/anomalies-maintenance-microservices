package com.example.surveillance.service;

import com.example.surveillance.dto.AlerteEvent;
import com.example.surveillance.entity.Alerte;
import com.example.surveillance.repository.AlerteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AlerteService {
  private final AlerteRepository alerteRepository;
  private final KafkaProducerService kafkaProducerService;

  public Alerte creerAlerte(Alerte alerte) {
    Alerte saved = alerteRepository.save(alerte);
    AlerteEvent event = AlerteEvent.builder()
        .alerteId(saved.getId())
        .type(saved.getType())
        .message(saved.getMessage())
        .niveauGravite(saved.getNiveauGravite())
        .dateDetection(saved.getDateDetection())
        .build();
    kafkaProducerService.envoyerAlerte(event);
    return saved;
  }

  public List<Alerte> toutes() { return alerteRepository.findAll(); }

  public Alerte parId(Long id) {
    return alerteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Alerte non trouvée: "+id));
  }
}
