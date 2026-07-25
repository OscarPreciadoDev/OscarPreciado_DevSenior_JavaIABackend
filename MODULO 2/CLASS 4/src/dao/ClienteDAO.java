package dao;

import java.util.List;
import model.Cliente;


// Clase que define un comportamiento y declara "OPERACIONES"
// Como que puede hacer el cliente.

public interface ClienteDAO {
    void insertar(Cliente cliente);
    List<Cliente> listar();
    void actualizar(Cliente cliente);
    void eliminar(int id);
}