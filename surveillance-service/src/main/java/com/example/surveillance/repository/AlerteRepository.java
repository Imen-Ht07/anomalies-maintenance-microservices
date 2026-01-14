package com.example.surveillance.repository;

import com.example.surveillance.entity.Alerte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlerteRepository extends JpaRepository<Alerte, Long> { }
