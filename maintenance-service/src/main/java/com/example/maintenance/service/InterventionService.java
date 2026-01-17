package com.example.maintenance.service;

import com.example.maintenance.client.SurveillanceClient;
import com.example.maintenance.dto.AlerteDTO;
import com.example.maintenance.dto.AlerteEvent;
import com.example.maintenance.entity.Intervention;
import com.example.maintenance.entity.Technicien;
import com.example.maintenance.repository.InterventionRepository;
import com.example.maintenance.repository.TechnicienRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class InterventionService {
  private final InterventionRepository interventionRepository;
  private final TechnicienRepository technicienRepository;
  private final SurveillanceClient surveillanceClient;

  public void creerInterventionDepuisAlerte(AlerteEvent event) {
    AlerteDTO details = surveillanceClient.obtenirAlerteParId(event.getAlerteId());
    List<Technicien> libres = technicienRepository.findByDisponibilite(true);
    if (libres.isEmpty()) {
      log.warn("Aucun technicien disponible pour l'alerte {}", event.getAlerteId());
      return;
    }
    Technicien t = libres.get(0);
    Intervention inter = Intervention.builder()
        .alerteId(details.getId())
        .technicienId(t.getId())
        .datePlanifiee(LocalDateTime.now().plusHours(2))
        .statut("EN_ATTENTE")
        .build();
    interventionRepository.save(inter);
    log.info("Intervention {} créée pour alerte {}", inter.getId(), details.getId());
  }

  public List<Intervention> toutes() { return interventionRepository.findAll(); }
  public Intervention parId(Long id) { return interventionRepository.findById(id).orElseThrow(); }
}
