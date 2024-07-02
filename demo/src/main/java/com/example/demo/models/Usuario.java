package com.example.demo.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")

public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 3, max = 50, message = "Debe haber entre 3 y 50 caracteres.")
    @Column(name = "nombre", length = 50)
    private String nombre;

    @NotBlank(message = "El correo es obligatorio.")
    @Size(min = 10, max = 50, message = "Debe haber entre 10 y 50 caracteres.")
    @Email(message = "El correo no es válido.")
    @Column(name = "correo", length = 50)
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria.")
    @Size(min = 8, max = 50, message = "Debe haber entre 8 y 50 caracteres.")
    @Column(name = "contraseña", length = 50)
    private String contraseña;

    @NotBlank(message = "La dirección es obligatoria.")
    @Size(min = 5, max = 100, message = "Debe haber entre 5 y 100 caracteres.")
    @Column(name = "direccion", length = 100)
    private String direccion;

    @NotBlank(message = "El teléfono es obligatorio.")
    @Pattern(regexp = "[0-9]{9,12}", message = "El teléfono debe tener entre 9 y 12 dígitos.")
    @Column(name = "telefono", length = 12)
    private String telefono;

    @OneToMany(mappedBy = "usuario")
    private List<Historial> compras;
}
