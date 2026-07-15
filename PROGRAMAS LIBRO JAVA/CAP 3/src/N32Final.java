/*
Escriba un programa que lea caracteres del teclado hasta que se reciba un punto. Haga que el programa cuente el número de espacios y reporte el total al final del programa
 */

import java.util.Scanner;

public class N32Final {
    public static void main(String[] args){

        // Variable de contador usada para numerar las entradas de espacio
        int contador = 0;

        // Variables iniciales
        char ch = '1';

        // Valor de entrada correcta declarada como valor final
        final char CORRECT = '.';

        // Se usa un Scanner para la entrada por teclado
        Scanner sc = new Scanner(System.in);

        // Bucle do-while
        do  {
            System.out.print("Ingrese una tecla: ");

            // Lee una entrada del Scanner
            String entrada = sc.nextLine();

            // Si la entrada está vacía, imprime mensaje de error
            if (entrada.isEmpty()){
                System.out.println("Error: no ingreso ningún valor...");

            // Si la entrada no está vacía
            } else {

                // Asigna a la variable de caracter el primer caracter de la entrada
                ch = entrada.charAt(0);

                // Verifica si la entrada es un espacio y aumenta el contador de ser asi
                if (ch == ' ') contador++;

                // Si la entrada no es igual a la respuesta correcta, sigue corriendo el bucle
                if (ch != CORRECT) System.out.println("Intentalo Nuevamente...");
            }

            // Mientras que el carácter sea diferente a la respuesta correcta
        } while (ch != CORRECT) ;

        // Mensaje de salida del bucle e imprime el contador de espacios
        System.out.println("Fin del bucle.\nLa cantidad de espacios ingresados fue: " + contador);

        // Cierre del Scanner
        sc.close();
    }

}
