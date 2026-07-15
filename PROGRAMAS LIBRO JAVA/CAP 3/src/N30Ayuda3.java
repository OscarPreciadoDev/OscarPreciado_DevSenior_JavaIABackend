// El siguiente programa crea una app de ayuda para poder visualizar diferentes opciones de bloques de código comunes en Java

import java.util.Scanner;

public class N30Ayuda3 {
    public static void main(String[] args) {

        // Variables a usar durante la verificacion, una para guardar el caracter de ingreso, y una entrada de Scanner

        char ch;
        Scanner sc = new Scanner(System.in);

        // Mensajes a imprimir en consola formateados desde antes

        String menuOpciones = """
               \nAyuda habilitada:
               1. if
               2. switch
               3. for
               4. while
               5. do-while
               6. break
               7. Continue
               
               Elija una (q para salir):\s""";

        String ayudaIf = """
                
                if:
                   if (condición) instrucción;
                   instrucción else;
                
                """;

        String ayudaSwitch = """
                
                switch:
                    switch (expresión) {
                        case (constante):
                            secuencia de instrucciones
                            break;
                        ...
                        case default:
                            secuencia de instrucciones
                            break;
                        }""";

        String ayudaFor = """
                
                for:
                    for (inicialización; condición; iteración){
                        secuencia de instrucciones
                        }""";

        String ayudaWhile = """
                
                while:
                    while (condición) {
                        secuencia de instrucciones
                    }""";

        String ayudaDoWhile = """
                
                do-while:
                    do {
                        instrucciones
                    } while (condición);""";

        String ayudaBreak = """
                
                break:
                    break; o break etiqueta;""";

        String ayudaContinue = """
                
                Continue:
                    continue; o continue etiqueta;""";

        // Bucle infinito para desplegar el menu hasta salir de la App

        for(;;){

            // Un ciclo que primero Imprime el menu de opciones
            do {
                System.out.print(menuOpciones);

                // Un ciclo que primero toma un carácter de la entrada Scanner
                do {
                    ch = sc.next().charAt(0);

                // Toma la entrada mientras que esta sea igual a un salto de línea para evitar errores
                // Cuando ingresa algo distinto (algún carácter) sale de este bucle.

                } while (ch == '\n' | ch == '\r');

            // Imprime el menu mientras que la entrada sea menor a uno, o sea mayor a 7, y sea diferente de 'q'.
            } while ((ch < '1') | ((ch > '7') & (ch != 'q')));

            // Si el usuario ingreso 'q', el programa sale del for infinito, dando fin al programa de forma organizada
            if (ch == 'q') break;

            // Luego de validar la entrada, se usa un switch para desplegar alguno de los mensajes descritos inicialmente
            // Para cada uno de los 7 casos del menu, no hay caso default, ya que se verificó previamente
            switch (ch) {
                case '1':
                    System.out.println(ayudaIf);
                    break;
                case '2':
                    System.out.println(ayudaSwitch);
                    break;
                case '3':
                    System.out.println(ayudaFor);
                    break;
                case '4':
                    System.out.println(ayudaWhile);
                    break;
                case '5':
                    System.out.println(ayudaDoWhile);
                    break;
                case '6':
                    System.out.println(ayudaBreak);
                    break;
                case '7':
                    System.out.println(ayudaContinue);
                    break;
            }
        }

        // Cierre del Scanner de entrada
        sc.close();

    }
}