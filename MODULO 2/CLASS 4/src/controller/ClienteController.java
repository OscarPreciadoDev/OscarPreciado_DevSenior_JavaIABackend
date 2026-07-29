package controller;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import model.Cliente;
import util.ListadoClientes;
import util.Validador;

import java.util.List;
import java.util.Scanner;

public class ClienteController {

    private final ClienteDAO clienteDAO = new ClienteDAOImpl();

    public void agregarCliente(Scanner sc) {
        String nombre = Validador.leerTexto(sc, "Nombre: ");
        String email  = Validador.leerEmail(sc, "Email: ");
        String ciudad = Validador.leerTexto(sc, "Ciudad: ");
        clienteDAO.insertar(new Cliente(nombre, email, ciudad));
    }

    public void listarClientes() {
        List<Cliente> clientes = clienteDAO.listar();
        ListadoClientes.listarClientes(clientes);
    }

    public void actualizarCliente(Scanner sc) {
        int id = Validador.leerEntero(sc, "\nID a actualizar: ");
        String nombre = Validador.leerTexto(sc, "Nuevo nombre: ");
        String email  = Validador.leerEmail(sc, "Nuevo email: ");
        String ciudad = Validador.leerTexto(sc, "Nueva ciudad: ");
        clienteDAO.actualizar(new Cliente(id, nombre, email, ciudad));
    }

    public void eliminarCliente(Scanner sc) {
        int id = Validador.leerEntero(sc, "\nID a eliminar: ");
        clienteDAO.eliminar(id);
    }
}