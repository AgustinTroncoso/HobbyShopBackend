package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Reseña;
import com.example.demo.repositories.ReseñaRepository;

import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor
public class ReseñaServices {
    
private final ReseñaRepository reseñaRepository;

public List<Reseña> getAll() throws Exception {
    try {
        return reseñaRepository.findAll();
    } catch (Exception e){
        throw new Exception("Error al buscar las Reseñas: " + e.getMessage());
    }
}


    public Reseña getReseñaByID(Long ID) throws Exception {
        return reseñaRepository.findById(ID).orElseThrow(
            () -> new Exception("Esta reseña no existe"));
    }

    public void deleteReseñaByID(Long ID) throws Exception {
        if (!reseñaRepository.existsById(ID)) {
            throw new Exception("Esta reseña no existe");
        }
        reseñaRepository.deleteById(ID);
    }
    public Reseña createReseña(Reseña reseñaToCreate) throws Exception {
        return reseñaRepository.save(reseñaToCreate);
    }


    public Reseña updateReseña(Reseña reseñaDetails) throws Exception {
        Reseña reseñaToUpdate = reseñaRepository.findById(reseñaDetails.getId())
            .orElseThrow(() -> new Exception("Esta reseña no existe"));

            reseñaToUpdate.setNombre(reseñaDetails.getNombre());
            reseñaToUpdate.setDescripcion(reseñaDetails.getDescripcion());
            reseñaToUpdate.setEstado(reseñaDetails.getEstado());

            return reseñaRepository.save(reseñaToUpdate);
    }

}
