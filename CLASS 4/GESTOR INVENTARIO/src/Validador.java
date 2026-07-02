/* VALIDADOR
    
    Que el usuario no rompa la app
    Antes de pedir datos necesarios, necesitamos una forma segura de pedirlos. Si pedimos un numero y el usuario escribe "hola", el programa se cae. El validador evita eso*/

import java.util.Scanner;


public class Validador {

    public static int leerEntero(Scanner sc, String mensaje) {

        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()){
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            }
            else {
                System.out.println("Eso no es un numero entero. Intenta de nuevo.");
                sc.nextLine();
            }
        }
    }

    public static double leerDecimal(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            }
            else {
                System.out.println("Eso no es un numero valido. Intenta de nuevo");
                sc.nextLine();
            }
        }
    }

    public static String leerTexto(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.next();
    }

}
