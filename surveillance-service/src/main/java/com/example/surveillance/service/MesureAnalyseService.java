package com.example.surveillance.service;

import com.example.surveillance.entity.Alerte;
import com.example.surveillance.entity.MesureAnalyse;
import com.example.surveillance.repository.MesureAnalyseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MesureAnalyseService {
  private final MesureAnalyseRepository mesureRepo;
  private final AlerteService alerteService;

  public MesureAnalyse enregistrer(MesureAnalyse m) {
    MesureAnalyse saved = mesureRepo.save(m);
    // Règle simple d'anomalie: si indicateur = TEMPERATURE et valeur > 80 -> alerte CRITIQUE
    if ("TEMPERATURE".equalsIgnoreCase(saved.getIndicateur()) && saved.getValeur() != null && saved.getValeur() > 80) {
      log.info("Anomalie détectée pour la mesure {} (valeur={})", saved.getId(), saved.getValeur());
      Alerte a = Alerte.builder()
          .type("TEMPERATURE")
          .message("Température au-dessus du seuil : " + saved.getValeur())
          .niveauGravite("CRITIQUE")
          .dateDetection(LocalDateTime.now())
          .build();
      alerteService.creerAlerte(a);
    }
    return saved;
  }
}
