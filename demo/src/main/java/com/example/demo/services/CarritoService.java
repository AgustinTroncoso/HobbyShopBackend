package com.example.demo.services;

import java.util.List;

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

    

    public void eliminarProductoDelCarrito(Long compradorId, Long productoId) {

        Carrito carrito = carritoRepository.findFirstByCompradorId(compradorId)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado para el comprador con ID: " + compradorId));

        Producto producto = carrito.getProductos().stream()
                .filter(p -> p.getId().equals(productoId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Producto no encontrado en el carrito con ID: " + productoId));

        
        carrito.getProductos().remove(producto);
        carritoRepository.save(carrito);
    }
    public Carrito agregarProducto(Long carritoId, Producto producto) {
        Carrito carrito = carritoRepository.findById(carritoId)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        Producto productoExistente = productoRepository.findById(producto.getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        carrito.getProductos().add(productoExistente);

        return carritoRepository.save(carrito);
    }

    
    public List<Producto> obtenerProductosPorComprador(Long compradorId) {
        Carrito carrito = carritoRepository.findFirstByCompradorId(compradorId)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado para el comprador con ID: " + compradorId));

        return carrito.getProductos();
    }
 
}
