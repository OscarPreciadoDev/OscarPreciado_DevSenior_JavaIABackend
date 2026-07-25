package config;

// Se importan las funcionalidades de sql a utilizar en el ejercicio
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Clase que define la conexión entre Java y Base de datos
public final class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/tienda";
    private static final String USUARIO = "";
    private static final String CLAVE = "";

    private ConexionBD() {
    }

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}