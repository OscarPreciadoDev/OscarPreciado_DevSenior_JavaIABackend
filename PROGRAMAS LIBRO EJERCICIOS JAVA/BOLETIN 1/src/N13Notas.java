/*
Pedir una nota de 0 a 5 y mostrarla de la forma: Insuficiente, Suficiente, Bien...
 */

import java.util.Scanner;

public class N13Notas {

    public static void main(String[] args) {

        boolean run = true;
        Scanner input = new Scanner(System.in);
        int numEntrada;

        String encabezado = ("=".repeat(50)+"\n\t\t\tNOTAS :)\n"+"=".repeat(50));
        String instrucciones = "\nIngrese una nota y se le mostrara su valoracion.\n(Debe ingresar una nota entre 0 y 5)";
        String pieDePrograma = ("\n"+"=".repeat(50)+"\n\t\t\tFIN DEL PROGRAMA\n"+"=".repeat(50));
        String mensajeNumeroErroneo = "ERROR: el numero ingresado esta fuera del rango.";
        String preguntaEjecucion = "\nDesea ingresar un nuevo numero? | (1) SI | (2) NO | ---> ";

        System.out.println(encabezado);
        do {
            System.out.println(instrucciones);
            numEntrada = Validador.leerEntero(input, "Ingrese su nota: ");

            if (validarRango(numEntrada)) {
                imprimirValoracion(numEntrada);
            } else System.out.println(mensajeNumeroErroneo);

            run = Validador.continuacionDelPrograma(input, preguntaEjecucion);

        } while (run);

        input.close();
        System.out.print(pieDePrograma);

    }

    public static boolean validarRango(int num){
        return num>=0 && num<=5;
    }

    public static void imprimirValoracion(int num){
        if (num == 0){
            System.out.println("\nMuy mala nota.");
            return;
        } else if (num>0 && num < 3) {
            System.out.println("\nInsuficiente.");
            return;
        } else if (num == 3) {
            System.out.println("\nNota minima aprobatoria.");
            return;
        } else if (num>3 && num < 4) {
            System.out.println("\nPuede mejorar el promedio.");
            return;
        } else if (num >= 4 && num < 5) {
            System.out.println("\nBuen promedio.");
            return;
        } else System.out.println("\nNota perfecta, felicitaciones!!!");
    }


}
