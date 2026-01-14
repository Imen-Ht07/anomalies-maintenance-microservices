package com.example.surveillance.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MesureAnalyse {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sourceId;
    private Double valeur;
    private String indicateur;
    private LocalDateTime date;
}
