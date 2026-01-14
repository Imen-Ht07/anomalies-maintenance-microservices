package com.example.surveillance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SurveillanceServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SurveillanceServiceApplication.class, args);
    }
}
