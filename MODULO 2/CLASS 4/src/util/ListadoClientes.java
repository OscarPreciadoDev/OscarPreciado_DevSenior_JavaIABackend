package util;


import java.util.List;
import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import model.Cliente;

public class ListadoClientes {

    // Un metodo que permita listar los clientes
    public static void listarClientes(List<Cliente> clientes) {

        // Encabezado formateado
        System.out.printf("%-5s %-20s %-25s %-15s%n", "ID", "Nombre", "Email", "Ciudad");

        // Ciclo que imprime los datos de cada cliente formateado
        for (Cliente c : clientes) {
            System.out.printf("%-5d %-20s %-25s %-15s%n",
                    c.getId(), c.getNombre(), c.getEmail(), c.getCiudad());
        }
    }

}
