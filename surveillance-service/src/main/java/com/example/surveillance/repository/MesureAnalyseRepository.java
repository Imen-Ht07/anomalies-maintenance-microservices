package com.example.surveillance.repository;

import com.example.surveillance.entity.MesureAnalyse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MesureAnalyseRepository extends JpaRepository<MesureAnalyse, Long> {
  List<MesureAnalyse> findBySourceId(String sourceId);
}
