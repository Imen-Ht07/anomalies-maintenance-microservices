package com.example.maintenance.repository;

import com.example.maintenance.entity.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterventionRepository extends JpaRepository<Intervention, Long> { }
