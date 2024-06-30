package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Producto;
import com.example.demo.repositories.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor
public class ProductoServices {

    private final ProductoRepository productoRepository;

       public List<Producto> getAll() throws Exception {
        try {
            return productoRepository.findAll();
        } catch (Exception e){
            throw new Exception("Error al buscar productos: " + e.getMessage());
        }
    }

    public Producto getProductoByID(Long ID) throws Exception {
        return productoRepository.findById(ID).orElseThrow(
            () -> new Exception("Este Producto no existe!"));


    }

    public void deleteProductoByID(Long ID) throws Exception {
        if (!productoRepository.existsById(ID)) {
            throw new Exception("This book doesn't exist!");
        }
        productoRepository.deleteById(ID);
    }


    public Producto createProducto(Producto ProductoToCreate) throws Exception {
        return productoRepository.save(ProductoToCreate);
    }

    public Producto updateBook(Producto productoDetails) throws Exception {
        Producto productoToUpdate = productoRepository.findById(productoDetails.getId())
            .orElseThrow(() -> new Exception("This book doesn't exist!"));

            productoToUpdate.setNombreproducto(productoDetails.getNombreproducto());
            productoToUpdate.setPrecio(productoDetails.getPrecio());
            productoToUpdate.setDescripcion(productoDetails.getDescripcion());
            productoToUpdate.setStock(productoDetails.getStock());
            productoToUpdate.setCategoria(productoDetails.getCategoria());
            productoToUpdate.setImageUrl(productoDetails.getImageUrl());

            return productoRepository.save(productoToUpdate);
    }




}
