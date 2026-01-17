package com.example.maintenance.client;

import com.example.maintenance.dto.AlerteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "surveillance-service")
public interface SurveillanceClient {
  @GetMapping("/api/alertes/{id}")
  AlerteDTO obtenirAlerteParId(@PathVariable("id") Long id);
}
