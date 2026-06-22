
import java.util.Scanner;

public class CajeroVFinal {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Pedido pedido = new Pedido(); 

        int opcion;

        do {
            System.out.println("\n--- CAJERO ---");
            System.out.println("1. Nuevo pedido");
            System.out.println("2. Cerrar caja");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Subtotal : ");
                    double subtotal = sc.nextDouble();
                    double total = pedido.CalcularTotal(subtotal, 0.10);
                    System.out.println("Total con propina: " + total);
                    break;
                case 2:
                    System.out.println("Caja cerrada");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 2);

        sc.close();
    }
}
