package com.example.demo.models;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "compras")

public class Compra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @NotBlank(message = "El nombre del producto es obligatorio.")
    @NotNull(message = "El nombre del producto no puede ser nulo.")
    @Size(min = 5, max = 50, message = "Debe haber entre 3 y 50 caracteres.")
    @Column(name = "nombreProducto", length = 50)
    private String nombreProducto;

    @NotBlank(message = "El precio es obligatorio.")
    @NotNull(message = "El precio no puede ser nulo.")
    @Size(min = 1, max = 10, message = "Debe haber entre 1 y 10 caracteres.")
    @Column(name = "precio", length = 10)
    private String precio;

    @NotBlank(message = "La fecha es obligatoria.")
    @NotNull(message = "La fecha no puede ser nula.")
    @Size(min = 10, max = 10, message = "Debe haber 10 caracteres.")
    @Column(name = "fecha", length = 10)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fecha;

    @NotBlank(message = "La cantidad es obligatoria.")
    @NotNull(message = "La cantidad no puede ser nula.")
    @Size(min = 1, max = 2, message = "Debe haber entre 1 y 2 caracteres.")
    @Column(name = "cantidad", length = 2)
    private Long cantidad;

    @NotBlank(message = "La descripción es obligatoria.")
    @NotNull(message = "La descripción no puede ser nula.")
    @Size(min = 5, max = 100, message = "Debe haber entre 5 y 100 caracteres.")
    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @NotBlank(message = "La URL de la imagen es obligatoria.")
    @NotNull(message = "La URL de la imagen no puede ser nula.")
    @Size(min = 5, max = 150, message = "Debe haber entre 5 y 150 caracteres.")
    @Column(name = "imageurl", length = 150)
    private String imageurl;

}
