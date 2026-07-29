import controller.ClienteController;
import dao.ClienteDAO;
import model.Cliente;
import util.Libreria;
import util.ListadoClientes;
import util.Validador;
import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import model.Cliente;


import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Libreria lib = new Libreria();
        boolean run = true;
        Scanner input = new Scanner(System.in);
        int eleccion;
        ClienteController controller = new ClienteController();


        System.out.println(lib.encabezado);

        do {
            System.out.println(lib.menu);
            eleccion = Validador.leerEleccion(input,"Ingrese una opcion: ");

            switch (eleccion) {
                case 1:
                    System.out.println(lib.instruccionEntrada);
                    controller.agregarCliente(input);
                    break;
                case 2:
                    System.out.println(lib.encabezadoLista);
                    controller.listarClientes();
                    break;
                case 3:
                    System.out.println(lib.encabezadoActualizar);
                    controller.listarClientes();
                    controller.actualizarCliente(input);
                    break;
                case 4:
                    System.out.println(lib.encabezadoEliminar);
                    controller.listarClientes();
                    controller.eliminarCliente(input);
                    break;
                case 5:
                    run = Validador.continuacionDelPrograma(eleccion);
                    break;
            }
        } while (run) ;

        input.close();
        System.out.println(lib.pieDeApp);

    }
}
