package com.uriel.servicioPreRegistro.Repositorio;

import com.uriel.servicioPreRegistro.Interfaces.IAspirante;
import com.uriel.servicioPreRegistro.Modelo.Aspirante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.uriel.servicioPreRegistro.Repositorio.SqlAspirante.*;

@Service
public class AspiranteRepImpl implements IAspirante {
    private final JdbcTemplate template;

    public AspiranteRepImpl(@Autowired JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Map<String, Object>> listar() {
        return template.queryForList(SQL_SELECT);
    }

    @Override
    public Integer add(Aspirante aspirante) {
        return template.update(SQL_INSERT, aspirante.getId(), aspirante.getNombre(),
                aspirante.getApellidos(), aspirante.getCurp(), aspirante.getFechanacimiento(),
                aspirante.getLugarnacimiento(), aspirante.getPais(), aspirante.getEstado(), aspirante.getMunicipio(),
                aspirante.getCodigo(), aspirante.getTelefonofijo(), aspirante.getTelefonocelular(),
                aspirante.getCorreo(), aspirante.getEscuela(), aspirante.getLicenciatura(),
                aspirante.getTutor(), aspirante.getNumeroficha());
    }

    @Override
    public Integer edit(Aspirante aspirante) {
        return template.update(SQL_UPDATE, aspirante.getNombre(), aspirante.getApellidos(), aspirante.getCurp(),
                aspirante.getFechanacimiento(), aspirante.getLugarnacimiento(), aspirante.getPais(),
                aspirante.getEstado(), aspirante.getMunicipio(), aspirante.getCodigo(), aspirante.getTelefonofijo(),
                aspirante.getTelefonocelular(), aspirante.getCorreo(), aspirante.getEscuela(), aspirante.getLicenciatura(),
                aspirante.getTutor(), aspirante.getNumeroficha(), aspirante.getId());
    }
    @Override
    public Integer delete(Integer id) {
        return template.update(SQL_DELETE,id);
    }

    public Integer generarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt();
    }
}
