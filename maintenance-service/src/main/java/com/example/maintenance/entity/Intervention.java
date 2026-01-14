package com.example.maintenance.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Intervention {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long alerteId;
    private Long technicienId;
    private LocalDateTime datePlanifiee;
    private String statut; // PLANIFIEE, EN_COURS, TERMINEE
}
