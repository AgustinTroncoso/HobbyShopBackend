package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Usuario;
import com.example.demo.services.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
@Validated
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody @Valid Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.registrarUsuario(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> loginUsuario(@RequestParam String email, @RequestParam String password) {
        Usuario usuario = usuarioService.loginUsuario(email, password);
        if (usuario == null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
    @GetMapping("/id")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.getUsuarioById(id);
        return usuarioOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/id")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
        Usuario usuarioActualizado = usuarioService.updateUsuario(id, usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

}