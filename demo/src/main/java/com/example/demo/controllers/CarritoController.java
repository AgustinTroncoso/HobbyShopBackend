package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Carrito;
import com.example.demo.models.Producto;
import com.example.demo.services.CarritoService;

@RestController
@RequestMapping("/api/carritos")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @PostMapping("/crear")
    public Carrito crearCarrito(@RequestParam Long compradorId, @RequestParam Long vendedorId) {
        return carritoService.crearCarrito(compradorId, vendedorId);
    }

      @PostMapping("/{carritoId}/agregar-producto")
    public ResponseEntity<Carrito> agregarProductoAlCarrito(@PathVariable Long carritoId, @RequestBody Producto producto) {
        try {
            Carrito carrito = carritoService.agregarProducto(carritoId, producto);
            return ResponseEntity.ok(carrito);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}