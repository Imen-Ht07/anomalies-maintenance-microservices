package com.example.surveillance.repository;

import com.example.surveillance.entity.Alerte;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlerteRepository extends JpaRepository<Alerte, Long> {
  List<Alerte> findByNiveauGravite(String niveauGravite);
}
