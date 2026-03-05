package org.example.atividade1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@RequestMapping("/api/sistema")
public class InfoController {

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> info() {
        String timestamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        Map<String, Object> payload = Map.of(
                "nome", "Sistema de Cadastro de Estudantes",
                "versao", "1.0.0",
                "dataHora", timestamp,
                "status", "operacional"
        );

        return ResponseEntity.ok(payload);
    }
}