package com.example.surveillance.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Alerte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String message;
    private String niveauGravite;
    private LocalDateTime dateDetection;
}
