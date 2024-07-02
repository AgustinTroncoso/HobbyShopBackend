package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Reseña;
import com.example.demo.services.ReseñaServices;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/reseña")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ReseñaController {
  
    
    
    private final ReseñaServices reseñaServices;

        @GetMapping("/todo")
    public ResponseEntity<?> getAllReseña() throws Exception {
        try {
            return ResponseEntity.ok(reseñaServices.getAll());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> createReseña(@RequestBody Reseña reseñaToCreate) throws Exception {
        try {
            return ResponseEntity.ok(reseñaServices.createReseña(reseñaToCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

  @DeleteMapping("/{reseñaID}")
    public ResponseEntity<?> deleteReseña(@PathVariable Long reseñaID) throws Exception {
        try {
            reseñaServices.deleteReseñaByID(reseñaID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    
    @PutMapping("/alterar")
    public ResponseEntity<?> updateReseña(@RequestBody Reseña reseñaToUpdate) throws Exception {
        try {
            return ResponseEntity.ok(reseñaServices.updateReseña(reseñaToUpdate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
