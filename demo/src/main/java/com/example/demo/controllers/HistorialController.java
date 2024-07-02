package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Historial;
import com.example.demo.services.HistorialService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/historial")
@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class HistorialController {
    
    private final HistorialService historialService;

    @GetMapping("/historial/{usuario_id}")
    public ResponseEntity<List<Historial>> getHistory(@PathVariable Long usuario_id) {
        try {
            return ResponseEntity.ok(historialService.getHistory(usuario_id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
