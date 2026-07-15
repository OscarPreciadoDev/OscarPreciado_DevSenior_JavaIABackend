/*
Este programa solicita dos números e imprime un mensaje indicando si uno es múltiplo del otro
 */

import java.util.Scanner;

public class N06Multiplos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        boolean desicion = true;


        do {

            System.out.println("*** NUMEROS MULTIPLOS *** ");
            System.out.println("Ingrese a continuación dos números para verificar si son múltiplos uno del otro.\n(nota) Si ingresa un numero negativo, este se tomara como positivo\n");

            num1 = Math.abs(leerEntero(sc, "Ingrese un primer numero: "));
            num2 = Math.abs(leerEntero(sc, "Ingrese un segundo numero: "));


            if (num1 == 0 || num2 == 0) {
                System.out.println("Error: No se puede evaluar múltiplos con el número 0.");
            } else {

                if (num1 == num2) {
                    System.out.println("Los dos números ingresados son iguales.");
                } else if (num1 < num2) {
                    if (compararMultiplos(num1, num2)) {
                        System.out.println("El numero " + num1 + " es factor del numero " + num2);
                    } else
                        System.out.println("El numero " + num1 + " no es factor del numero " + num2);
                } else {
                    if (compararMultiplos(num2, num1)) {
                        System.out.println("El numero " + num2 + " es factor del numero " + num1);
                    } else
                        System.out.println("El numero " + num2 + " no es factor del numero " + num1);
                }
            }
            desicion = leerOpcion(sc, "Desea ingresar un nuevo numero? (S/N) : ");
        } while (desicion);
        sc.close();
    }

    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                int numero = sc.nextInt();
                sc.nextLine();
                return numero;
            } else {
                System.out.println("Error: Debe ingresar un numero entero");
                sc.nextLine();
            }
        }
    }

    public static boolean compararMultiplos(int menor, int mayor) {
        return (mayor % menor) == 0;
    }

    public static boolean leerOpcion(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().toUpperCase();
            if (!(entrada.isEmpty())) {
                char ch = entrada.charAt(0);
                if (ch == 'S') {
                    System.out.println("Volviendo al inicio...\n\n");
                    return true;
                } else if (ch == 'N') {
                    System.out.println("saliendo del programa...");
                    return false;
                } else System.out.println("Error: Debe ingresar una opción valida.");

            } else {
                System.out.println("Error: debe ingresar una opción.");
            }
        }
    }

}
