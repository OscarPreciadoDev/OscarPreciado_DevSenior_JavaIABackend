/*
Este programa demuestra el uso de break en bucles anidados
 */

public class N24BreakBuclesAnidados {
    public static void main(String[] args) {
        for (int i = 0 ; i < 3 ; i++ ) {
            System.out.println("Cuenta del bucle externo: " + i);
            System.out.print("  Cuenta del bucle interno: ");

            int t = 0;
            while (t<100) {
                if ( t == 10) break;
                System.out.print(t + " ");
                t++;
            }
            System.out.println();
        }
        System.out.println("Bucles completos.");
    }
}
