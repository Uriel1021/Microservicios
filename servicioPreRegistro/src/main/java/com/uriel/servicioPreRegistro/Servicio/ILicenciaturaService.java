package com.uriel.servicioPreRegistro.Servicio;

import com.uriel.servicioPreRegistro.Interfaces.ILicenciatura;
import com.uriel.servicioPreRegistro.Modelo.Licenciatura;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ILicenciaturaService implements ILicenciatura {
    @Override
    public Licenciatura obtenerLicenciaturaPorDetalle(String campus) {
        String url = "http://localhost:8083/licenciatura/seach";
        return new RestTemplate().getForObject(url, Licenciatura.class, campus);
    }
}
