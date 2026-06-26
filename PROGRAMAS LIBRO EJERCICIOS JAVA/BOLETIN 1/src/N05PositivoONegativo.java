// Pedir un numero e indicar si es positivo o negativo

import java.util.Scanner;

public class N05PositivoONegativo {

    public static void main(String[] args) {
        
        double i;
        Scanner sc = new Scanner(System.in);

        System.out.println("** NUMERO POSITIVO O NEGATIVO");
        System.out.print("Ingrese un numero: ");
        i = sc.nextDouble();

        if (i>0) {
            System.out.println("EL numero " + i + " es positivo.");
        }
        else if (i< 0) {
            System.out.println("El numero " + i + " es negativo");
        }
        else { 
            System.out.println("El numero ingresado es " + i);
        }

        sc.close();

    }
}
