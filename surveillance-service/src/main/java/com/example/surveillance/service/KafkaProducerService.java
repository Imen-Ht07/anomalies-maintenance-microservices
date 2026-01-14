package com.example.surveillance.service;

import com.example.surveillance.dto.AlerteEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private static final Logger log = LoggerFactory.getLogger(KafkaProducerService.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishAlerte(String topic, AlerteEvent event) {
        log.info("Publication Kafka sur {}: {}", topic, event);
        kafkaTemplate.send(topic, event);
    }
}
