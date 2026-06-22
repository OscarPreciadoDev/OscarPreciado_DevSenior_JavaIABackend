/*
    Pide un numero entre 1 y 5; si esta fuera de rango, vuelve a pedirlo. Solo termina cuando el dato es valido.
*/

import java.util.Scanner;

public class EjercicioDoWhile {
    public static void main(String[] args) {

        int numeroIngresado;
        
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Ingrese un numero entre 1 y 5: ");
            numeroIngresado = sc.nextInt();
            if (numeroIngresado < 1 || numeroIngresado > 5){
                System.out.println("Numero fuera de rango, intente de nuevo.");
            }
        } while (numeroIngresado < 1 || numeroIngresado > 5);

        System.out.println("Numero valido: "+ numeroIngresado);

        sc.close();

    }
}
