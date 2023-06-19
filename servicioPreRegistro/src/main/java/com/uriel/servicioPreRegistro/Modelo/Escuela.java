package com.uriel.servicioPreRegistro.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
public class Escuela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "pais")
    private String pais;

    @Column(name = "estado")
    private String estado;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "codigo")
    private String codigo;

}