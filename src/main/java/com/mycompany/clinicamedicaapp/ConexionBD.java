package com.mycompany.clinicamedicaapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // Configuracion de SQL Server
    private static final String URL =
            "jdbc:sqlserver://127.0.0.1:1433;"
                    + "databaseName=bd_clinica;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;";
    // Credenciales de SQL Server
    private static final String USER = "sa";
    private static final String PASSWORD = "Admin12345";
    // Metodo para obtener la conexion
    public static Connection getConexion() {
        Connection cn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa a bd_clinica");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error de conexion: " + e.getMessage());
        }
        return cn;
    }
}
