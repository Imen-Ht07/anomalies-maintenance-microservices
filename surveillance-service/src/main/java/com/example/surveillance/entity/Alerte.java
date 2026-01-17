package com.example.surveillance.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alertes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alerte {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String type;

  @Column(nullable = false)
  private String message;

  @Column(name = "niveau_gravite", nullable = false)
  private String niveauGravite; // FAIBLE, MOYEN, CRITIQUE

  @Column(name = "date_detection", nullable = false)
  private LocalDateTime dateDetection;
}
