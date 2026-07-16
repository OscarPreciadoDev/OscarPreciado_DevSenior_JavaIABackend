/*
Pedir un número entre 0 y 9999 y mostrarlo con las cifras alreves

METODO: CASTEO A STRING Y CHAR, INVERSION DE ARRAY
 */

import java.util.Scanner;

public class N11VoltearNumero {
    public static void main(String[] args) {
        int num;
        boolean run = true;
        Scanner sc = new Scanner(System.in);

        String encabezado = """
                *** INVERSOR DE CIFRAS   ***
                En el siguiente programa se le solicitara un numero y el programa lo devolvera con sus cifras alrevez.
                (nota) el numero debe estar entre 0 y 9999
                """;

        String preguntaEjecucion = "Desea ingresar una nuevo Numero? | (1) SI | (2) NO | ---> ";

        System.out.println(encabezado);
        do {
            num = Validador.leerEntero(sc, "Ingrese un numero: ");
            if (validarRango(num)){
                invertirNum(num);
            } else {
                System.out.println("Error: numero invalido.");
            }
            run = Validador.continuacionDelPrograma(sc, preguntaEjecucion);

        } while (run);

    }

    public static void invertirNum(int num){

        // Conversion a String
        String numString = String.valueOf(num);

        // Conversion a arreglo de char
        char[] digitos = numString.toCharArray();

        // Array del tamaño correcto vacio
        char[] digitosAlreves = new char[digitos.length];

        // Se guarda en el nuevo arreglo los caracteres a la inversa
        for (int i =  1 ; i <= digitos.length ; i++){
            digitosAlreves[i-1] = digitos[digitos.length - i];
        }

        // Se castea a String el arreglo de char invertido
        String numStringAlreves =  new String(digitosAlreves);

        // Se castea a numero el String resultante
        int numAlrevez = Integer.parseInt(numStringAlreves);
        System.out.println("El numero " + num + " alreves es " + numAlrevez);
    }

    public static boolean validarRango(int num){
        return num >= 0 && num <= 9999;
    }
}
