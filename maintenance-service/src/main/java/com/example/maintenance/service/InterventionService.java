package com.example.maintenance.service;

import com.example.maintenance.client.SurveillanceClient;
import com.example.maintenance.dto.AlerteDTO;
import com.example.maintenance.dto.AlerteEvent;
import com.example.maintenance.entity.Intervention;
import com.example.maintenance.entity.Technicien;
import com.example.maintenance.repository.InterventionRepository;
import com.example.maintenance.repository.TechnicienRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class InterventionService {
    private static final Logger log = LoggerFactory.getLogger(InterventionService.class);

    private final InterventionRepository interventionRepository;
    private final TechnicienRepository technicienRepository;
    private final SurveillanceClient surveillanceClient;

    @Transactional
    public Intervention planifierInterventionDepuis(AlerteEvent event) {
        log.info("Réception alerte event: {}", event);
        AlerteDTO alerteDetails = surveillanceClient.getAlerteById(event.getId());
        Technicien tech = technicienRepository.findFirstByDisponibiliteTrue()
                .orElseGet(() -> technicienRepository.save(Technicien.builder()
                        .nom("Auto-Assign")
                        .specialite("Généraliste")
                        .disponibilite(true)
                        .build()));
        Intervention inter = Intervention.builder()
                .alerteId(alerteDetails.getId())
                .technicienId(tech.getId())
                .datePlanifiee(LocalDateTime.now().plusHours(1))
                .statut("PLANIFIEE")
                .build();
        return interventionRepository.save(inter);
    }
}
