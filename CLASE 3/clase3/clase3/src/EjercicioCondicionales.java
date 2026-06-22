/*
    Pide la edad con Scanner e imprime "Menor de edad" si es menor a 18, "Adulto" entre 18 y 53, "Aduto mayor" si es 65 o mas.
*/

import java.util.Scanner;

public class EjercicioCondicionales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;

        System.out.print("Ingrese su edad: ");
        edad = sc.nextInt();

        if ( edad >= 0 && edad <18 ) {
            System.out.println("Menor de edad");
        } else if (edad >= 18 && edad <= 53 ) {
            System.out.println("Adulto");
        } else if (edad > 53 ) {
            System.out.println("Adulto mayor");
        } else {
            System.out.println("Fuera de rango");
        }
        sc.close();
    }
}
