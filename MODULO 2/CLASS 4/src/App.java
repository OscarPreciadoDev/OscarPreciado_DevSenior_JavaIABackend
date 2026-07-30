import controller.ClienteController;
import util.Lib;
import util.Validador;


import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        boolean run = true;
        Scanner input = new Scanner(System.in);
        int eleccion;
        ClienteController controller = new ClienteController();


        System.out.println(Lib.encabezado);

        do {
            System.out.println(Lib.menu);
            eleccion = Validador.leerEleccion(input,"Ingrese una opcion: ");

            switch (eleccion) {
                case 1:
                    System.out.println(Lib.instruccionEntrada);
                    controller.agregarCliente(input);
                    break;
                case 2:
                    System.out.println(Lib.encabezadoLista);
                    controller.listarClientes();
                    break;
                case 3:
                    System.out.println(Lib.encabezadoActualizar);
                    controller.listarClientes();
                    controller.actualizarCliente(input);
                    break;
                case 4:
                    System.out.println(Lib.encabezadoEliminar);
                    controller.listarClientes();
                    controller.eliminarCliente(input);
                    break;
                case 5:
                    run = Validador.continuacionDelPrograma(eleccion);
                    break;
            }
        } while (run) ;

        input.close();
        System.out.println(Lib.pieDeApp);

    }
}
