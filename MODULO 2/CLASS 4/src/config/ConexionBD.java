package config;

// Se importan las funcionalidades de sql a utilizar en el ejercicio
// estas vienen del funcionamiento de JDBC (del package de java.sql)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Clase que define la conexión entre Java y Base de datos
public final class ConexionBD {

    // Atributos finales, son los arguementos para crear la conexion con MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/tienda";
    private static final String USUARIO = "root";
    private static final String CLAVE = "CLASSW1Z.##";

    // Ya que es una clase de utilidad, se realiza privada, para que no puedan construir instancias de este
    private ConexionBD() {
    }


    // Un metodo que devuelve un objeto de Connection
    public static Connection obtenerConexion() throws SQLException {
        // Devuelve la conexion usando los argumentos necesarios
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}