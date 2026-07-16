/*
Pedir un número entre 0 y 9999 y decir cuantas citras tiene
 */

import java.util.Scanner;

public class N10CifrasNumericas {
    public static void main(String[] args) {
        int num;
        boolean run = true;
        Scanner sc = new Scanner(System.in);

        String encabezado = """
                *** CONTADOR DE CIFRAS ***
                En el siguiente programa al ingresar un numero se le indicara cuantas cifras tiene.
                (nota) el numero debe estar entre 0 y 9999
                """;

        String preguntaEjecucion = "Desea ingresar una nuevo Numero? | (1) SI | (2) NO | ---> ";

        System.out.println(encabezado);
        do {
            num = Validador.leerEntero(sc, "Ingrese un numero: ");
            if (validarRango(num)){
                contarCifras(num);
            } else {
                System.out.println("Error: numero invalido.");
            }
            run = Validador.continuacionDelPrograma(sc, preguntaEjecucion);

        } while (run);

    }

    public static void contarCifras(int num){
        String numString = String.valueOf(num);
        int tamanio = numString.length();
        System.out.println("El numero " + num + " tiene " + tamanio + " cifras");
    }

    public static boolean validarRango(int num){
        return num >= 0 && num <= 9999;
    }
}
