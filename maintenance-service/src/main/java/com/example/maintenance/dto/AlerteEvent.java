package com.example.maintenance.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AlerteEvent {
    private Long id;
    private String type;
    private String niveauGravite;
    private LocalDateTime dateDetection;
}
