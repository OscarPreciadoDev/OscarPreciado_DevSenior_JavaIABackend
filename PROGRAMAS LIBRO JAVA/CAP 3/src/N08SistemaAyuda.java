/*  En este proyecto se construye un sistema simple de ayuda que despliega la sintaxis para las instrucciones de control de Java. El programa despliega un menu que contiene las instrucciones de control y luego espera que usted elija una. Despues de esto, se despliega la sintaxis de la instruccion. En esta primera version del programa, la ayuda solo esta disponible para las instrucciones if y switch. Las instrucciones de control restantes se agregan en proyectos posteriores */

import java.util.Scanner;

public class N08SistemaAyuda {

    public static void main(String[] args) {
        System.out.println("Ayuda habilitada: ");
        System.out.println("1. if");
        System.out.println("2. Switch");
        System.out.print("Eliga una: ");

        Scanner sc = new Scanner(System.in);

        char inciso = sc.next().charAt(0);

        switch (inciso) {
            case '1':
                System.out.println("if:\n");
                System.out.println("if(condicion) instruccion;");
                System.out.println("Instruccion else;");
                break;
        case '2':
            System.out.println("switch:\n");
            System.out.println("switch(expresion) {");
            System.out.println("    constante case:");
            System.out.println("        secuencia de instrucciones");
            System.out.println("        break;");
            System.out.println("    //...");
            System.out.println("}");
            default:
                System.out.println("Seleccion no encontrada.");
                break;
            
        }

        sc.close();
    }
}
