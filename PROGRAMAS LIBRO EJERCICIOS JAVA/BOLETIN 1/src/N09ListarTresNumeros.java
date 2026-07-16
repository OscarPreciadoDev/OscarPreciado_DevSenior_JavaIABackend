/*
Pedir tres numeros y mostrarlos ordenados de mayor a menor
 */

import java.util.Scanner;
import java.util.Arrays;

public class N09ListarTresNumeros {

    public static void main(String[] args){
        int num1,num2, num3;
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        String encabezado = """
                \t\t *** LISTADO DE TRES NUMEROS ***
                Ingrese tres números y el programa los devolvera ordenados de mayor a menor
                """;

        String preguntaEjecucion = "Desea ingresar una nueva lista? | (1) SI | (2) NO | ---> ";

        System.out.println(encabezado);
        do {
            num1 = Validador.leerEntero(sc, "Ingrese un numero: ");
            num2 = Validador.leerEntero(sc, "Ingrese otro numero: ");
            num3 = Validador.leerEntero(sc, "Ingrese el ultimo numero: ");

            ListarNumOrganizados(num1,num2,num3);

            run = Validador.continuacionDelPrograma(sc, preguntaEjecucion);

        } while (run);
        System.out.println("Fin del programa.");

        sc.close();
    }


    // Metodo que compara cuál es el mayor entre dos números.

    public static void ListarNumOrganizados(int num1, int num2, int num3) {

        int[] numeros = {num1, num2, num3};
        Arrays.sort(numeros);
        for(int i = 2; i >=0 ; i --) System.out.println(numeros[i]);

    }



}