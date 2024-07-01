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

import com.example.demo.models.Compra;
import com.example.demo.services.CompraService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/compras")
@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class CompraController {
    
    private final CompraService compraService;

    @GetMapping("/historial/{usuario_id}")
    public ResponseEntity<List<Compra>> getPurchase(@PathVariable Long usuario_id) {
        try {
            return ResponseEntity.ok(compraService.getPurchase(usuario_id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
