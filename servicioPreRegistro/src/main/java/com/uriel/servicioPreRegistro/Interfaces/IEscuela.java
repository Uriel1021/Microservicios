package com.uriel.servicioPreRegistro.Interfaces;

import com.uriel.servicioPreRegistro.Modelo.Escuela;

public interface IEscuela {
    Escuela[] obtenerEscuelas();
    Escuela agregarEscuela(Escuela escuela);

    Escuela editarEscuela(Escuela escuela);

    Escuela[] buscarEscuela(String nombre);

    Escuela eliminarEscuela(Integer id);
}
