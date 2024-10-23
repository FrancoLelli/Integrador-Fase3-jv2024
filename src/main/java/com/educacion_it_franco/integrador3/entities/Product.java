package com.educacion_it_franco.integrador3.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data  // Lombok se encargará de generar getters, setters, equals, hashCode, toString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private double precio;

    private int stock;
}
