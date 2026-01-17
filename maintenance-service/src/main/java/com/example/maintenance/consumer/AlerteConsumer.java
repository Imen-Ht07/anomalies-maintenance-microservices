package com.example.maintenance.consumer;

import com.example.maintenance.dto.AlerteEvent;
import com.example.maintenance.service.InterventionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AlerteConsumer {
  private final InterventionService interventionService;

  @KafkaListener(topics = "alertes-topic", groupId = "maintenance-group")
  public void consommer(AlerteEvent event) {
    log.info("[Maintenance] Alerte reçue: {}", event.getAlerteId());
    interventionService.creerInterventionDepuisAlerte(event);
  }
}
