package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="reseña")
public class Reseña {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    
    @Column(name = "estado", length = 20)
    private String estado;


}
