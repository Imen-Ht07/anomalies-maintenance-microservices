package com.example.maintenance.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlerteDTO {
  private Long id;
  private String type;
  private String message;
  private String niveauGravite;
  private LocalDateTime dateDetection;
}
