package com.example.maintenance.client;

import com.example.maintenance.dto.AlerteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SURVEILLANCE-SERVICE", path = "/api/alertes")
public interface SurveillanceClient {
    @GetMapping("/{id}")
    AlerteDTO getAlerteById(@PathVariable("id") Long id);
}
