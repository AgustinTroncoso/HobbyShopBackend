package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Compra;
import com.example.demo.repositories.CompraRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;

    public List<Compra> getPurchase(Long Id) throws Exception {
        try {
            return compraRepository.findByUsuarioId(Id);
        } catch (Exception e) {
            throw new Exception("Error al buscar las compras: " + e.getMessage());
        }
    }

}
