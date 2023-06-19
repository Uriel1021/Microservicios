package com.uriel.servicioLicenciatura.Repository;

public class Sql {
    protected static String SQL_SELECT = "SELECT * FROM licenciatura";
    protected static String SQL_INSERT = "INSERT INTO licenciatura (nombrelic, campus, ubicacion, codigo) VALUES (?, ?, ?, ?)";
    protected static String SQL_UPDATE = "UPDATE licenciatura SET campus = ?, codigo = ?, nombrelic = ?, ubicacion = ? WHERE id = ?";
    protected static String SQL_DELETE = "DELETE FROM licenciatura WHERE id = ?";
    protected static String SQL_SEACH = SQL_SELECT + " WHERE nombrelic LIKE ? OR campus LIKE ? OR ubicacion LIKE ?";
}
