package org.example.atividade1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
public class InfoController {

    @Value("${spring.application.name:demo}")
    private String appName;

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> info() {
        String javaVersion = System.getProperty("java.version");
        String timestamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        String message = "Aplicação funcionando";

        Map<String, Object> payload = Map.of(
                "appName", appName,
                "javaVersion", javaVersion,
                "timestamp", timestamp,
                "message", message
        );

        return ResponseEntity.ok(payload);
    }
}