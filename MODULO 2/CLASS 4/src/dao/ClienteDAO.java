package dao;

import java.util.List;
import model.Cliente;


// Clase que define un comportamiento y declara "OPERACIONES"
// Como que puede hacer el cliente.

public interface ClienteDAO {


    // Crea un metodo abstracto que recibe un objeto de tipo Cliente
    void insertar(Cliente cliente);


    // Un metodo abstracto que lista los clientes
    List<Cliente> listar();


    // Crea un metodo abstracto que actualiza un objeto de tipo cliente
    void actualizar(Cliente cliente);

    // Creaun metodo abstracto que elimina un cliente desde su ID
    void eliminar(int id);
}