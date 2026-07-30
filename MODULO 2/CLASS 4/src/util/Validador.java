package util;
import model.Cliente;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validador{

    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } else {
                System.out.println("Error: debe ingresar un numero.");
                sc.nextLine();
            }
        }
    }

    public static int leerEleccion(Scanner sc, String mensaje) {
        while (true) {
            int eleccion = leerEntero(sc,mensaje);
            if (eleccion >=1 && eleccion <=5) {
                return eleccion;
            } else {
                System.out.println("ERROR: el numero " + eleccion + " no es una opcion valida.");
            }
        }
    }

    public static boolean continuacionDelPrograma(int eleccion){
        return eleccion != 5;
    }

    public static String leerTexto(Scanner input, String mensaje){
        String nombreEntrada;
        while (true) {
            System.out.print(mensaje);
            if (input.hasNextLine()) {
                nombreEntrada= input.nextLine();
                return  nombreEntrada;
            } else {
                System.out.println("ERROR: Debe ingresar un nombre.");
            }
        }
    }

    // exite una sintaxis que tenga items antes y despues de @ y una extension de almenos 2 letras
    private static final Pattern EMAIL_REGEX =
            Pattern.compile("^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$");

    public static String leerEmail(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String email = sc.nextLine();
            if (EMAIL_REGEX.matcher(email).matches()) {
                return email;
            } else {
                System.out.println("ERROR: el email ingresado no tiene un formato valido.");
            }
        }
    }
}
