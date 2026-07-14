// El siguiente programa crea una app de ayuda para poder visualizar diferentes opciones de bloques de código comunes en Java

import java.util.Scanner;

public class N21Ayuda2 {
    public static void main(String[] args) {

        char ch;
        Scanner sc = new Scanner(System.in);

        String menuOpciones = """
               \nAyuda habilitada:
               1. if
               2. switch
               3. for
               4. while
               5. do-while
               \s
               Elija una:\s""";

        do {
            System.out.print(menuOpciones);
            do {
                ch = sc.next().charAt(0);
            } while (ch == '\n' | ch == '\r');
        } while( ch < '1' | ch > '5');

        switch (ch) {
            case '1':
                System.out.println("""
                        
                        if:
                            if (condición) instrucción;
                            instrucción else;""");
                break;
            case '2':
                System.out.println("""
                        
                        switch:
                            switch (expresión) {
                                case (constante):
                                    secuencia de instrucciones
                                    break;
                                ...
                                case default:
                                    secuencia de instrucciones
                                    break;
                                }""");
                break;
            case '3':
                System.out.println("""
                        
                        for:
                            for (inicialización; condición; iteración){
                                secuencia de instrucciones
                                }""");
                break;
            case '4':
                System.out.println("""
                        
                        while:
                            while (condición) {
                                secuencia de instrucciones
                            }""");
                break;
            case  '5':
                System.out.println("""
                        
                        do-while:
                            do {
                                instrucciones
                            } while (condición);""");
        }

        sc.close();

    }
}
