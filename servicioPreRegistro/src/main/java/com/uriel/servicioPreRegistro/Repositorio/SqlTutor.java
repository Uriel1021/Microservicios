package com.uriel.servicioPreRegistro.Repositorio;

public class SqlTutor {
    public static final String SQL_SELECT = "SELECT * FROM tutor";
    public static final String SQL_INSERT = "INSERT INTO tutor (parentesco, nombre, apellidos, pais, estado, municipio, codigo, telefonofijo, telefonocelular, correo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_UPDATE = "UPDATE tutor SET parentesco = ?, nombre = ?, apellidos = ?, pais = ?, estado = ?, municipio = ?, codigo = ?, telefonofijo = ?, telefonocelular = ?, correo = ? WHERE id = ?";
    public static final String SQL_DELETE = "DELETE FROM tutor WHERE id = ?";
    public static final String SQL_SEACH = SQL_SELECT + " WHERE id = ?";
}


