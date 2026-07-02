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
                System.out.println("Error, debe ingresar un numero entero. Intente nuevamente.");
                sc.nextLine();
            }
        }
    }

}
