package com.uriel.servicioLicenciatura.Repository;

import com.uriel.servicioLicenciatura.interfaz.ILicenciatura;
import com.uriel.servicioLicenciatura.modelo.Licenciatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.uriel.servicioLicenciatura.Repository.Sql.*;

@Service
public class LicenciaturaRepImpl implements ILicenciatura {
    private final JdbcTemplate template;

    public LicenciaturaRepImpl(@Autowired JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Map<String, Object>> listar() {
        return template.queryForList(SQL_SELECT);
    }

    @Override
    public Integer add(Licenciatura licenciatura) {
        return template.update(SQL_INSERT,
                licenciatura.getNombrelic(),
                licenciatura.getCampus(),
                licenciatura.getUbicacion(),
                licenciatura.getCodigo());
    }

    @Override
    public Integer edit(Licenciatura licenciatura) {
        System.out.println(licenciatura.toString());
        return template.update(SQL_UPDATE,
                licenciatura.getCampus(),
                licenciatura.getCodigo(),
                licenciatura.getNombrelic(),
                licenciatura.getUbicacion(),
                licenciatura.getId());
    }

    @Override
    public Integer delete(Integer id) {
        return template.update(SQL_DELETE, id);
    }

    @Override
    public List<Map<String, Object>> buscar(String nombreUniversidad, String campus, String licenciatura) {
        return template.queryForList(SQL_SEACH, "%" + licenciatura + "%", "%" + campus + "%", "%" + nombreUniversidad + "%");
    }

}
