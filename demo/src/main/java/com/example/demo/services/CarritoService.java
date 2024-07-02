package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Carrito;
import com.example.demo.models.Producto;
import com.example.demo.models.Usuario;
import com.example.demo.repositories.CarritoRepository;
import com.example.demo.repositories.ProductoRepository;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class CarritoService {
    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public Carrito crearCarrito(Long compradorId, Long vendedorId) {
        Usuario comprador = usuarioRepository.findById(compradorId)
                .orElseThrow(() -> new RuntimeException("Usuario comprador no encontrado"));
        Usuario vendedor = usuarioRepository.findById(vendedorId)
                .orElseThrow(() -> new RuntimeException("Usuario vendedor no encontrado"));

        Carrito carrito = new Carrito();
        carrito.setComprador(comprador);
        carrito.setVendedor(vendedor);

        return carritoRepository.save(carrito);
    }

    
    public Carrito agregarProducto(Long carritoId, Producto producto) {
        Carrito carrito = carritoRepository.findById(carritoId)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        Producto productoExistente = productoRepository.findById(producto.getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        carrito.getProductos().add(productoExistente);

        return carritoRepository.save(carrito);
    }
 
}
