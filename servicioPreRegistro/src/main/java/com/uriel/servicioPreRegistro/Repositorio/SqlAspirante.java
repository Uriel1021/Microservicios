package com.uriel.servicioPreRegistro.Repositorio;

public class SqlAspirante {
    protected static String SQL_SELECT = "SELECT * FROM aspirante";
    protected static String SQL_INSERT = "INSERT INTO aspirante (id, nombre, apellidos, curp, fechanacimiento, lugarnacimiento, pais, estado, municipio, codigo, telefonofijo, telefonocelular, correo, escuela, licenciatura, tutor, numeroficha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    protected static String SQL_UPDATE = "UPDATE aspirante SET nombre = ?, apellidos = ?, curp = ?, fechanacimiento = ?, lugarnacimiento = ?, pais = ?, estado = ?, municipio = ?, codigo = ?, telefonofijo = ?, telefonocelular = ?, correo = ?, escuela = ?, licenciatura = ?, tutor = ?, numeroficha = ? WHERE id = ?";
    protected static String SQL_DELETE = "DELETE FROM aspirante WHERE id = ?";
}