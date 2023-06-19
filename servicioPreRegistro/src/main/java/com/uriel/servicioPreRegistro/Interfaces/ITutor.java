package com.uriel.servicioPreRegistro.Interfaces;

import com.uriel.servicioPreRegistro.Modelo.Tutor;

import java.util.List;
import java.util.Map;

public interface ITutor {
    List<Map<String, Object>> listar();
    Integer add(Tutor tutor);
    Integer edit(Tutor tutor);
    Integer delete(Integer id);
    List<Map<String, Object>> existeTutor(Integer id);
}
