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
@Table(name="producto")
public class Producto {
        @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nombreproducto", length=8)
    private String nombreproducto;

    @Column(name="precio", length=30)
    private Integer precio;

    @Column(name="descripcion", length=500)
    private String descripcion;

    @Column(name="stock", length=30)
    private Integer stock;

    @Column(name="imageUrl", length=300)
    private String imageUrl;


}
