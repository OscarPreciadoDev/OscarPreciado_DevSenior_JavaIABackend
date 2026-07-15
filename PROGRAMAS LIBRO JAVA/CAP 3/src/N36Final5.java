/*
Las letras minúsculas en ASCII están separadas de las mayúsculas por 32 caracteres. Por lo tanto, para convertir una minúscula en mayúscula se restan 32
use esa información para crear un programa que lea caracteres del teclado. Haga que todas las minúsculas se conviertan en mayúsculas y todas las mayúsculas se
conviertan en minúsculas desplegando el resultado. No le haga cambios a ningún otro carácter. Logre que el programa se detenga cuando el usuario oprima el punto,
al final haga que el programa despliegue el número de cambios de letras que se realizaron.
 */

import java.util.Scanner;

public class N36Final5 {
    public static void main(String[] args) {

        // Variables del programa

        // Contador de los cambios de letra exitosos
        int contador = 0;

        // Scanner para leer las entradas de teclado
        Scanner sc = new Scanner(System.in);

        // Variables para almacenar los caracteres de entrada y salida
        char chEntrada, chSalida;

        // Carácter de salida del bucle
        final char PUNTOFINAL = '.';

        // Bucle que primer solicita un carácter y luego verifica que sea diferente del carácter de salida
        do {


            System.out.print("Ingrese una tecla: ");

            // Toma una tecla usando el metodo seguro que evita los espacios en blanco
            chEntrada = tomarEntrada(sc);

            // Verifica que el carácter ingresado sea una letra mayúscula
            if (chEntrada >= 'A' && chEntrada <= 'Z') {

                // Le suma 32 según indica el ejercicio y aumenta el contador
                chSalida = (char) (chEntrada + 32);
                contador++;

                // Imprime la conversion solicitada
                System.out.println("\nLetra de entrada : " +chEntrada + "\t | Letra de salida: " + chSalida + "\n");

            // Verifica que el carácter ingresado sea una letra minúscula
            } else if (chEntrada >= 'a' && chEntrada <= 'z') {

                // Hace la conversion restando 32 posiciones y aumenta el contador
                chSalida = (char) (chEntrada - 32);
                contador++;

                // Imprime la conversion solicitada
                System.out.println("\nIngreso la tecla : " +chEntrada + "\t | Letra de salida: " + chSalida + "\n");

            // Si el carácter de entrada es igual al carácter de salida, imprime el resumen de cantidad de conversiones
            } else if (chEntrada == PUNTOFINAL) {
                System.out.println("Cantidad final de cambios de letra: "  + contador);
                System.out.println("Fin del programa");

            // Si no cumple ninguna condición (se asume una tecla distinta a los rangos dados, se imprime error)

            } else {System.out.println("Error: la tecla ingresada no es una letra...\n");}

        } while( chEntrada != PUNTOFINAL);

        // Cierre del Scanner
        sc.close();
    }


    // Metodo para tomar una entrada y evitar ingreso de líneas vacías
    public static char tomarEntrada(Scanner scanner){
        while(true){
            String entrada = scanner.nextLine();
            if (entrada.isEmpty()){
                System.out.println("Error: No ingreso ningún valor.");
                continue;
            } else {
                return entrada.charAt(0);
            }
        }
    }

}
