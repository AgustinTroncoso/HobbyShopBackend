package com.example.demo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Usuario;
import com.example.demo.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    public final UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    } 

    public Usuario loginUsuario(String email, String password) {
        return usuarioRepository.findByEmailAndPassword(email, password);
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario updateUsuario(Long id, Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioActualizado = usuarioOptional.get();
            usuarioActualizado.setNombre(usuario.getNombre());
            usuarioActualizado.setCorreo(usuario.getCorreo());
            usuarioActualizado.setContraseña(usuario.getContraseña());
            usuarioActualizado.setDireccion(usuario.getDireccion());
            usuarioActualizado.setTelefono(usuario.getTelefono());
            return usuarioRepository.save(usuarioActualizado);
        } else {
            throw new RuntimeException("Usuario no encontrado con id: "+id);
        }
    }
}
