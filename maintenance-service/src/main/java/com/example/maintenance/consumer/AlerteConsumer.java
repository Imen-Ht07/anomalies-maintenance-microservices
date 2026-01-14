package com.example.maintenance.consumer;

import com.example.maintenance.dto.AlerteEvent;
import com.example.maintenance.service.InterventionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlerteConsumer {
    private static final Logger log = LoggerFactory.getLogger(AlerteConsumer.class);
    private final InterventionService interventionService;

    @KafkaListener(topics = "alertes-topic", groupId = "maintenance-group")
    public void onAlerte(AlerteEvent event) {
        log.info("Kafka message reçu: {}", event);
        interventionService.planifierInterventionDepuis(event);
    }
}
