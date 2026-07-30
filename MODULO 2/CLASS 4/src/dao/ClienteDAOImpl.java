package dao;

import config.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteDAOImpl implements ClienteDAO {

    // Sobreescribe el metodo contratado de la interfaz ClienteDAO
    @Override
    // Recordar que este metodo agrega un registro a la tabla Cliente de la base de datos

    public void insertar(Cliente cliente) {

        // String que se mandara como instruccion a SQL, se pone ? donde iran los parametros a enviar
        String sql = "INSERT INTO cliente (nombre, email, ciudad) VALUES (?, ?, ?)";

        // Se intenta crear una conexion llamada "con" y uun PreparedStatment llamada "ps".
        try (Connection con = ConexionBD.obtenerConexion();

             // Prepara una consulta, pero aún no se saben los valores.
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Asigna Strings en los parametros los datos dados del cliente
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCiudad());

            // Genera la instruccion SQL y almacena la cantidad de filas afectadas
            int filas = ps.executeUpdate();
            // Imprime un mensaje en consola de cuantas filas fueron afectadas
            System.out.println("Filas insertadas: " + filas);

            // En caso de tener un error SQLException, imprime un mensaje indicando el error, evita que se tumbe el programa
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    // Se define el contrato para listar()
    @Override
    public List<Cliente> listar() {

        // Se crea una lista de clientes llamada cliente, donde se utilizara una clase de List (ArrayList)
        List<Cliente> clientes = new ArrayList<>();

        // Instruccion SQL que se ejecutara, esta instruccion devolvera una tabla con los datos solicitados de la tabla cliente
        String sql = "SELECT id, nombre, email, ciudad FROM cliente";

        // intenta crear una conexion (con) usando la clase Conexion.BD
        try (Connection con = ConexionBD.obtenerConexion();

             //crea una declaracion preparada (ps) y le pasa como parametro la instruccion (sql), se guarda en esta variable
             PreparedStatement ps = con.prepareStatement(sql);

             // Ejecuta ps, y guarda los datos devueltos en un objeto ResultSet (rs)
             ResultSet rs = ps.executeQuery()) {

            // mientras que haya una siguiente fila dentro del elemento rs
            while (rs.next()) {

                // crea un Cliente, usando los getters de los elementos de cada columna en orden
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("ciudad")
                );

                // agrega a la lista de clientes cada cliente creado con los datos obtenidos del registro
                clientes.add(cliente);
            }

            // Si hay algun error de SQLException, lo capta y evita que el programa se caiga
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        
        // Devuelve la lista de clientes
        return clientes;
    }


    // Sobre escritura del metodo contratado de clienteDAO
    @Override

    // Metodo vacio que utilizara como parametro un cliente de clase Cliente
    public void actualizar(Cliente cliente) {

        // String que almacenara la instruccion tipo SQL, donde ? se cambiara por los atributos del objeto usuario
        String sql = "UPDATE cliente SET nombre = ?, email = ?, ciudad = ? WHERE id = ?";

        // Intenta crear una conexion (con) usando la clase ConexionBD (metodo obtenerConexion())
        try (Connection con = ConexionBD.obtenerConexion();

             // Se crea un elemento PreparedStatment (ps) donde se pasa en la conexion el prepareStatment con la instruccion sql como parametro
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Esta declaracion se le pasarán los siguientes datos como parametros para remplazar los placeholder (?)

            // Se asigna a cada posicion los datos correspondientes (Atributos del objeto Usuario)
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCiudad());
            ps.setInt(4, cliente.getId());

            // Finalmente, se imprime un mensaje indicando cuantas filas fueron actualizadas

            System.out.println("Filas actualizadas: " + ps.executeUpdate());

            // De ocurrir un SQLException, se capta y se imprime un mensaje en consola indicando el error
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    // Se sobreescribe el metodo contratado de ClienteDAO
    @Override
    // Consistira en un metodo vacio que recibe un int (id del usuario) como parametro
    public void eliminar(int id) {

        // Sentencia SQL donde (?) se cambiara por el id
        String sql = "DELETE FROM cliente WHERE id = ?";

        // Intenta crear una conexion con la base de datos
        try (Connection con = ConexionBD.obtenerConexion();

             // crea un PreparedStatment donde pasada a la conexion la sentencia sql cambiando el placeholder por el id)
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            // Confirma en consola las filas eliminadas
            System.out.println("Filas eliminadas: " + ps.executeUpdate());

        // Da manejo a las excepciones SQLException para que el programa no caiga
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}