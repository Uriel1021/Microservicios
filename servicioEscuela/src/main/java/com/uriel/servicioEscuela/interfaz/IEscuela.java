package com.uriel.servicioEscuela.interfaz;

import com.uriel.servicioEscuela.modelo.Escuela;

import java.util.List;
import java.util.Map;

public interface IEscuela {
    List<Map<String, Object>> listar();
    Integer add(Escuela escuela);
    Integer edit(Escuela escuela);
    Integer delete(Integer id);
    List<Map<String, Object>> buscar(String nombre);
}
