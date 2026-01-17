package com.example.maintenance.repository;

import com.example.maintenance.entity.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TechnicienRepository extends JpaRepository<Technicien, Long> {
  List<Technicien> findByDisponibilite(Boolean disponibilite);
}
