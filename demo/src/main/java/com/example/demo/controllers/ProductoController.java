package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Producto;
import com.example.demo.services.ProductoServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor

public class ProductoController {
    

    private final ProductoServices productoServices;

        @GetMapping("/todo")
    public ResponseEntity<?> getAllProducto() throws Exception {
        try {
            return ResponseEntity.ok(productoServices.getAll());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> createProducto(@RequestBody Producto productoToCreate) throws Exception {
        try {
            return ResponseEntity.ok(productoServices.createProducto(productoToCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

  @DeleteMapping("/{productoID}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long productoID) throws Exception {
        try {
            productoServices.deleteProductoByID(productoID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    
    @PutMapping("/alterar")
    public ResponseEntity<?> updateProducto(@RequestBody Producto bookToUpdate) throws Exception {
        try {
            return ResponseEntity.ok(productoServices.updateBook(bookToUpdate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



}
