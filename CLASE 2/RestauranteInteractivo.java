/*
    Importamos "Scanner", lo creamos, pedimos la cuenta y el numero de personas, y dividimos el total. Estas son las cinco partes de todo el programa con "Scanner".
*/

import java.util.Scanner; // 1. Importa la libreria de Scanner, siempre va arriba del todo 

public class RestauranteInteractivo {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);// 2. crear el lector 

        System.out.println(">> ¿Cuánto fue la cuenta? ");
        double cuenta = sc.nextDouble(); // 3. Leer un punto flotante

        System.out.println(">> ¿Cuántas personas? ");
        int personas = sc.nextInt(); // 4. Leer un entero

        // BLOQUE EXPLICATIVO DEL BUG DEL ENTER DE SCANNER

        sc.nextLine(); // Consume el salto de linea pendiente del int

        System.out.println(">> Nombre de quien paga: ");
        String nombre = sc.nextLine();

        System.out.println(">> Gracias, "+ nombre);

        double propina = cuenta * 0.1;
        double total = cuenta + propina;
        double porPersona = total / personas;

        System.out.println(">> Total con propina: "+ total);
        System.out.println(">> Cada persona paga :"+porPersona);

        sc.close(); //  5. Cerrar el lector

    }

}
