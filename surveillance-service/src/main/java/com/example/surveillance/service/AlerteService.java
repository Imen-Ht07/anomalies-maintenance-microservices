package com.example.surveillance.service;

import com.example.surveillance.dto.AlerteEvent;
import com.example.surveillance.entity.Alerte;
import com.example.surveillance.repository.AlerteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AlerteService {
    private final AlerteRepository alerteRepository;
    private final KafkaProducerService producerService;

    @Value("${spring.kafka.template.default-topic:alertes-topic}")
    private String alertesTopic;

    @Transactional
    public Alerte create(Alerte a) {
        Alerte saved = alerteRepository.save(a);
        AlerteEvent evt = AlerteEvent.builder()
                .id(saved.getId())
                .type(saved.getType())
                .niveauGravite(saved.getNiveauGravite())
                .dateDetection(saved.getDateDetection())
                .build();
        producerService.publishAlerte(alertesTopic, evt);
        return saved;
    }

    public Alerte get(Long id) { return alerteRepository.findById(id).orElse(null); }
}
