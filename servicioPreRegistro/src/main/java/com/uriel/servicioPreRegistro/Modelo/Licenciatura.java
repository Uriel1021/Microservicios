package com.uriel.servicioPreRegistro.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "licenciatura")
@Getter
@Setter
@ToString
public class Licenciatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombrelic")
    private String nombrelic;

    @Column(name = "campus")
    private String campus;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "codigo")
    private String codigo;
}
