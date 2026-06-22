/*
    Simula una cuenta regresiva desde un numero que pida el usuario hasta 0, imprimiendo "!Despegue!" al final.
*/

import java.util.Scanner;

public class EjercicioCicloWhile {
    public static void main(String[] args) {
        
        int entrada;

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un numero para la cuenta regresiva: ");
        entrada = sc.nextInt();

        sc.close();

        while (entrada>=0) {
            System.out.println(entrada);
            entrada--;
        }
        System.out.println("!Despegue");
    }
}
