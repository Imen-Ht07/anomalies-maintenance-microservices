package com.example.maintenance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "techniciens")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Technicien {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nom;

  @Column(nullable = false)
  private String specialite;

  @Column(nullable = false)
  private Boolean disponibilite; // true = disponible
}
