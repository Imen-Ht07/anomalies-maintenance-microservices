package com.example.maintenance.repository;

import com.example.maintenance.entity.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InterventionRepository extends JpaRepository<Intervention, Long> {
  List<Intervention> findByAlerteId(Long alerteId);
  List<Intervention> findByStatut(String statut);
}
