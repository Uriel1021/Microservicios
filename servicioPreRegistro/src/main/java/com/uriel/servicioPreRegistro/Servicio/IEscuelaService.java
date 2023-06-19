package com.uriel.servicioPreRegistro.Servicio;

import com.uriel.servicioPreRegistro.Interfaces.IEscuela;
import com.uriel.servicioPreRegistro.Modelo.Escuela;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IEscuelaService implements IEscuela {
    @Override
    public Escuela[] obtenerEscuelas() {
        String url = "http://localhost:8084/escuela/list";
        return new RestTemplate().getForObject(url, Escuela[].class);
    }

    @Override
    public Escuela agregarEscuela(Escuela escuela) {
        String url = "http://localhost:8084/escuela/add";
        return new RestTemplate().postForObject(url, escuela, Escuela.class);
    }

    @Override
    public Escuela editarEscuela(Escuela escuela) {
        String url = "http://localhost:8084/escuela/edit";
        return new RestTemplate().postForObject(url, escuela, Escuela.class);
    }

    @Override
    public Escuela[] buscarEscuela(String nombre) {
        String url = "http://localhost:8084/escuela/seach/"+nombre;
        return new RestTemplate().getForObject(url,Escuela[].class);
    }

    @Override
    public Escuela eliminarEscuela(Integer id) {
        String url = "http://localhost:8084/escuela/delete/"+id;
        return new RestTemplate().postForObject(url, id, Escuela.class);
    }


}
