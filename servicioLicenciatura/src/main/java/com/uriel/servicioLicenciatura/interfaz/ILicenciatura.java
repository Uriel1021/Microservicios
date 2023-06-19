package com.uriel.servicioLicenciatura.interfaz;

import com.uriel.servicioLicenciatura.modelo.Licenciatura;

import java.util.List;
import java.util.Map;

public interface ILicenciatura {
    List<Map<String, Object>> listar();

    Integer add(Licenciatura licenciatura);

    Integer edit(Licenciatura licenciatura);

    Integer delete(Integer id);

    List<Map<String, Object>> buscar(String nombreUniversidad, String campus, String licenciatura);

}
