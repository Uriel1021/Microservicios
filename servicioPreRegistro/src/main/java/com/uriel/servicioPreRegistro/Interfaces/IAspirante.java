package com.uriel.servicioPreRegistro.Interfaces;

import com.uriel.servicioPreRegistro.Modelo.Aspirante;

import java.util.List;
import java.util.Map;

public interface IAspirante {
    List<Map<String, Object>> listar();
    Integer add(Aspirante aspirante);
    Integer edit(Aspirante aspirante);
    Integer delete(Integer id);

    Integer generarNumeroAleatorio();
}
