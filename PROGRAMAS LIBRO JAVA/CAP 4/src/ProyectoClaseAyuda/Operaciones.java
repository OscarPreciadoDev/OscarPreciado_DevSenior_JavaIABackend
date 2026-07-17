//

package ProyectoClaseAyuda;

import java.util.Scanner;

public class Operaciones {

    static BibliotecaTextos textos = new BibliotecaTextos();
    Scanner input =  new Scanner(System.in);

    public static void DesplegarAyuda(char opcion) {
        switch (opcion) {
            case '1':
                System.out.println("\n" +"=".repeat(50));
                System.out.println(textos.ayudaIf);
                System.out.println("=".repeat(50)+"\n");
                break;
            case '2':
                System.out.println("\n" +"=".repeat(50));
                System.out.println(textos.ayudaSwitch);
                System.out.println("=".repeat(50)+"\n");
                break;
            case '3':
                System.out.println("\n" +"=".repeat(50));
                System.out.println(textos.ayudaFor);
                System.out.println("=".repeat(50)+"\n");
                break;
            case '4':
                System.out.println("\n" +"=".repeat(50));
                System.out.println(textos.ayudaWhile);
                System.out.println("=".repeat(50)+"\n");
                break;
            case '5':
                System.out.println("\n" +"=".repeat(50));
                System.out.println(textos.ayudaDoWhile);
                System.out.println("=".repeat(50)+"\n");
                break;
            case '6':
                System.out.println("\n" +"=".repeat(50));
                System.out.println(textos.ayudaBreak);
                System.out.println("=".repeat(50)+"\n");
                break;
            case '7':
                System.out.println("\n" +"=".repeat(50));
                System.out.println("=".repeat(50)+"\n");
                System.out.println(textos.ayudaContinue);
            default:
                System.out.println();
                break;
        }
    }

}
