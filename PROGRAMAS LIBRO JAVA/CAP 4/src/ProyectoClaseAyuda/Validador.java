package ProyectoClaseAyuda;

import java.util.Scanner;

public class Validador {
    public static char leerOpcion(Scanner input, String texto){
        while(true){
            System.out.print(texto);
            char entrada =  input.next().charAt(0);
            entrada = Character.toLowerCase(entrada);
            if ( (entrada >='1' && entrada <='7') || entrada == 'q' ){
                return entrada;
            } else {
                System.out.println("ERROR: Debe ingresar una opción valida");
            }
        }
    }

    public static boolean validarEjecucion(char opcion){
        return opcion != 'q';
    }
}
