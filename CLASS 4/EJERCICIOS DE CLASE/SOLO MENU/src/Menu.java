import java.util.Scanner;

public class Menu {

    public static void llamarMenu(){

        System.out.println();
        System.out.println("*** MENU DE OPCIONES ***");
        System.out.println("1. Opcion 1");
        System.out.println("2. Opcion 2");
        System.out.println("3. Salir");
    }

    public static int tomarOpcion(Scanner sc){
        int opcion = Validador.leerEntero(sc, "Ingrese una opcion: ");
        return opcion;
        }
    }
