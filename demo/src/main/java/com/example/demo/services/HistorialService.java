package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Historial;
import com.example.demo.repositories.HistorialRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class HistorialService {

    private final HistorialRepository historialRepository;

    public List<Historial> getHistory(Long Id) throws Exception {
        try {
            return historialRepository.findByUsuarioId(Id);
        } catch (Exception e) {
            throw new Exception("Error al mostrar historial: " + e.getMessage());
        }
    }

}
