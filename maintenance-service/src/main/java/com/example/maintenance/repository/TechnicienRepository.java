package com.example.maintenance.repository;

import com.example.maintenance.entity.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnicienRepository extends JpaRepository<Technicien, Long> {
    Optional<Technicien> findFirstByDisponibiliteTrue();
}
