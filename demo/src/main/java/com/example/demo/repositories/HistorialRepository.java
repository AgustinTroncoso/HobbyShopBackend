package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Historial;

@Repository
public interface HistorialRepository extends JpaRepository<Historial,Long>{
    
    List<Historial> findByUsuarioId(Long id);

}
