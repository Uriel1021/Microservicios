package com.uriel.servicioEscuela.Repository;
public class Sql {
    protected static String SQL_SELECT = "SELECT * FROM escuela";
    protected static String SQL_INSERT = "INSERT INTO escuela (id, nombre, pais, estado, municipio, codigo) VALUES (?, ?, ?, ?, ?, ?)";
    protected static String SQL_UPDATE = "UPDATE escuela SET nombre = ?, pais = ?, estado = ?, municipio = ?, codigo = ? WHERE id = ?";
    protected static String SQL_DELETE = "DELETE FROM escuela WHERE id = ?";
    protected static String SQL_SEACH = SQL_SELECT + " WHERE nombre LIKE ? LIMIT 1";

}
