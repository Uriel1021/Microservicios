package com.uriel.servicioPreRegistro.Repositorio;

import com.uriel.servicioPreRegistro.Interfaces.ITutor;
import com.uriel.servicioPreRegistro.Modelo.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.uriel.servicioPreRegistro.Repositorio.SqlTutor.*;

@Service
public class TutorRepImpl implements ITutor {
    private final JdbcTemplate template;

    public TutorRepImpl(@Autowired JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Map<String, Object>> listar() {
        return template.queryForList(SQL_SELECT);
    }

    @Override
    public Integer add(Tutor tutor) {
        return template.update(SQL_INSERT, tutor.getParentesco(), tutor.getNombre(), tutor.getApellidos(),
                tutor.getPais(), tutor.getEstado(), tutor.getMunicipio(), tutor.getCodigo(), tutor.getTelefonofijo(),
                tutor.getTelefonocelular(), tutor.getCorreo());
    }

    @Override
    public Integer edit(Tutor tutor) {
        return template.update(SQL_UPDATE, tutor.getParentesco(), tutor.getNombre(), tutor.getApellidos(),
                tutor.getPais(), tutor.getEstado(), tutor.getMunicipio(), tutor.getCodigo(), tutor.getTelefonofijo(),
                tutor.getTelefonocelular(), tutor.getCorreo(), tutor.getId());
    }

    @Override
    public Integer delete(Integer id) {
        return template.update(SQL_DELETE, id);
    }

    @Override
    public List<Map<String, Object>> existeTutor(Integer id) {
        return template.queryForList(SQL_SEACH,id);
    }
}