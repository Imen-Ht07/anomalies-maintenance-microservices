package com.example.maintenance.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "interventions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Intervention {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "alerte_id", nullable = false)
  private Long alerteId;

  @Column(name = "technicien_id", nullable = false)
  private Long technicienId;

  @Column(name = "date_planifiee", nullable = false)
  private LocalDateTime datePlanifiee;

  @Column(nullable = false)
  private String statut; // EN_ATTENTE, EN_COURS, TERMINEE
}
