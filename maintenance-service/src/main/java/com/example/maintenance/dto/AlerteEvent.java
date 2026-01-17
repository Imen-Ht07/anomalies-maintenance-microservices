package com.example.maintenance.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlerteEvent {
  private Long alerteId;
  private String type;
  private String message;
  private String niveauGravite;
  private LocalDateTime dateDetection;
}
