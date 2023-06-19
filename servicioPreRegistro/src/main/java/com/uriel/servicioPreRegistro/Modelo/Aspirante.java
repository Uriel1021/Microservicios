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
public class Aspirante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "curp")
    private String curp;

    @Column(name = "fechanacimiento")
    private String fechanacimiento;

    @Column(name = "lugarnacimiento")
    private String lugarnacimiento;

    @Column(name = "pais")
    private String pais;

    @Column(name = "estado")
    private String estado;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "telefonofijo")
    private String telefonofijo;

    @Column(name = "telefonocelular")
    private String telefonocelular;

    @Column(name = "correo")
    private String correo;
    //Escuela de procedencia
    @Column(name = "escuela")
    private String escuela;
    //Seleccion de licenciatura
    @Column(name = "licenciatura")
    private String licenciatura;

    @Column(name = "tutor")
    private int tutor;

    @Column(name = "numeroficha")
    private Integer numeroficha;
}
