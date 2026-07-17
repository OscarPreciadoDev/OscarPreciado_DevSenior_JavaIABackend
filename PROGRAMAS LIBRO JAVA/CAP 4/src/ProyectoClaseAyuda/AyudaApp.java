package ProyectoClaseAyuda;

import java.util.Scanner;

public class AyudaApp {
    public static void main(String[] args) {

        boolean run = true;
        BibliotecaTextos textos = new BibliotecaTextos();
        Scanner input = new Scanner(System.in);


        System.out.println("=".repeat(50));
        System.out.println("\t\t\t\tAPP DE AYUDA JAVA");
        System.out.println("=".repeat(50));

        do{
            System.out.println(textos.instrucciones);
            System.out.println(textos.menuOpciones);
            char opcion = Validador.leerOpcion(input, "Opción: ");

            Operaciones.DesplegarAyuda(opcion);

            run = Validador.validarEjecucion(opcion);

        } while (run);


        input.close();

        System.out.println("=".repeat(50));
        System.out.println("\t\t\t\tFIN DEL PROGRAMA");
        System.out.println("=".repeat(50));

    }
}
