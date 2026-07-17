package ProyectoClaseAyuda;

public class BibliotecaTextos {

    String instrucciones = """
            Bienvenido al menu principal!!
            Eliga una opción de las siguientes para desplegar 
            la sintaxis de la ayuda solicitada.""";

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
                        }
                """;

    String ayudaFor = """
                
                for:
                    for (inicialización; condición; iteración){
                        secuencia de instrucciones
                        }
                """;

    String ayudaWhile = """
                
                while:
                    while (condición) {
                        secuencia de instrucciones
                    }
                """;

    String ayudaDoWhile = """
                
                do-while:
                    do {
                        instrucciones
                    } while (condición);
                """;

    String ayudaBreak = """
                
                break:
                    break; o break etiqueta;
                """;

    String ayudaContinue = """
                
                Continue:
                    continue; o continue etiqueta;
                """;

    void imprimirInstrucciones(){
        System.out.println(instrucciones);
        return;
    }

}
