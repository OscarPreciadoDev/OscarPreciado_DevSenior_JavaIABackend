// Pedir dos numeros y decir si son iguales o no

import java.util.Scanner;

public class N04CompararNumeros {
    public static void main(String[] args) {
        
        int a,b;
        Scanner sc= new Scanner(System.in);

        System.out.println("*** COMPARADOR DE NUMEROS ***");
        System.out.print("Ingrese un numero: ");
        a = sc.nextInt();

        System.out.print("Ingrese otro numero: ");
        b = sc.nextInt();

        if (a == b) {
            System.out.println("Los numeros " + a + " " + b + " son iguales.");
        }
        else {
            System.out.println("Los numeros " + a + " " + b + " no son iguales");
        }

        sc.close();
    }
}
