package com.example.surveillance.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mesures_analyse")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MesureAnalyse {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "source_id", nullable = false)
  private String sourceId;

  @Column(nullable = false)
  private Double valeur;

  @Column(nullable = false)
  private String indicateur;

  @Column(nullable = false)
  private LocalDateTime date;
}
