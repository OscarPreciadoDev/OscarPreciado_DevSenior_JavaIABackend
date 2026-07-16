/*
Pedir dos numeros y mostrarlos ordenados de mayor a menor
 */

import java.util.Scanner;

public class N08ListarNumeros {

    public static void main(String[] args){
        int num1,num2;
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        String encabezado = """
                \t\t *** LISTADO DE NUMEROS ***
                Ingrese dos números y el programa los devolvera ordenados de mayor a menor
                """;

        String preguntaEjecucion = "Desea ingresar una nueva lista? | (1) SI | (2) NO | ---> ";

        System.out.println(encabezado);
        do {
            num1 = Validador.leerEntero(sc, "Ingrese un numero: ");
            num2 = Validador.leerEntero(sc, "Ingrese otro numero: ");

            compararNumeros(num1,num2);

            run = Validador.continuacionDelPrograma(sc, preguntaEjecucion);

        } while (run);
        System.out.println("Fin del programa.");

        sc.close();
    }


    // Metodo que compara cuál es el mayor entre dos números.

    public static void compararNumeros(int num1, int num2) {
        if (num1 > num2) {
            System.out.println(num1 + " " + num2);
            return;
        } else if (num1 < num2) {
            System.out.println(num2 + " " + num1);
            return;
        } else {
            System.out.println("Los dos números son iguales.");
        }
    }



}
