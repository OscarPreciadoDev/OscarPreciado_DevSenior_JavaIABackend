/*
El siguiente programa solicita dos números y devuelve una respuesta indicando cuál es mayor.
 */

import java.util.Scanner;

public class N07MayorDeDosNumeros {

    public static void main(String[] args){
        int num1,num2;
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        String encabezado = """
                \t\t *** COMPARADOR DE NUMEROS ***
                Ingrese dos numeros y el programa le indicara cual es el mayor
                
                """;

        System.out.println(encabezado);
        do {
            num1 = leerNumero(sc, "Ingrese un numero: ");
            num2 = leerNumero(sc, "Ingrese otro numero: ");

            compararNumeros(num1,num2);



        } while (run);

    }

    public static int leerNumero(Scanner sc, String texto){
        while (true){
            System.out.print(texto);
            if(sc.hasNextInt()){
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } else {
                System.out.println("Error: El valor ingresado no es un numero.");
                sc.nextLine();
            }
        }
    }

    public static void compararNumeros(int num1, int num2) {
        if (num1 > num2) {
            System.out.println("El numero " + num1 + " es mayor que el numero " + num2);
            return;
        } else if (num1 < num2) {
            System.out.println("El numero " + num2 + " es mayor que el numero " + num1);
            return;
        } else {
            System.out.println("Los dos números son iguales.");
        }
    }

}
