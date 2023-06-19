package com.uriel.servicioEscuela.Repository;

import com.uriel.servicioEscuela.interfaz.IEscuela;
import com.uriel.servicioEscuela.modelo.Escuela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.uriel.servicioEscuela.Repository.Sql.*;

@Service
public class EscuelaRepImpl implements IEscuela {
    private final JdbcTemplate template;

    public EscuelaRepImpl(@Autowired JdbcTemplate template){
        this.template = template;
    }


    @Override
    public List<Map<String, Object>> listar() {
        return template.queryForList(SQL_SELECT);
    }

    @Override
    public Integer add(Escuela escuela) {
        return template.update(SQL_INSERT, escuela.getId(), escuela.getNombre(),escuela.getPais(),escuela.getEstado(), escuela.getMunicipio(),escuela.getCodigo());
    }

    @Override
    public Integer edit(Escuela escuela) {
        return template.update(SQL_UPDATE, escuela.getNombre(),escuela.getPais(),escuela.getEstado(),
                escuela.getMunicipio(),escuela.getCodigo(),escuela.getId());
    }

    @Override
    public Integer delete(Integer id) {
        return template.update(SQL_DELETE,id);
    }

    @Override
    public List<Map<String, Object>> buscar(String nombre) {
        return template.queryForList(SQL_SEACH,  "%" + nombre + "%");
    }
}
