package com.example.surveillance.service;

import com.example.surveillance.dto.AlerteEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {
  private final KafkaTemplate<String, AlerteEvent> kafkaTemplate;
  private static final String TOPIC = "alertes-topic";

  public void envoyerAlerte(AlerteEvent event) {
    log.info("[Surveillance] Envoi de l'alerte {} vers Kafka", event.getAlerteId());
    kafkaTemplate.send(TOPIC, event.getAlerteId().toString(), event);
  }
}
