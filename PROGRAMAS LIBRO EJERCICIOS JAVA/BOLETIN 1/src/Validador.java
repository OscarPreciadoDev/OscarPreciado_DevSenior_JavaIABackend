import java.util.Scanner;

// Clase utilizada para practicidades de ingreso de datos usado desde el ejercicio 7 en adelante

public class Validador {

    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } else {
                System.out.println("Error: debe ingresar un numero.");
                sc.nextLine();
            }
        }

    }

    public static boolean continuacionDelPrograma(Scanner sc, String mensaje) {
        while (true) {
            int entrada = Validador.leerEntero(sc, mensaje);
            if (entrada == 1 ) return true;
            if (entrada == 2) return false;
            System.out.println("Error: debe ingresar una opcion valida.");
        }
    }

}
