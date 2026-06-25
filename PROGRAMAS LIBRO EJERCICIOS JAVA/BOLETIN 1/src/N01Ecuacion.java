/*Pedir los coeficientes de una ecuacion de segundo grado 
y muestre sus soluciones reales. Si no existen, debe
indicarlo 

Tener presente en la ecuacion cuadratica general: 

d (determinante) = (b^2) - (4 x a x c) 
x (soluciones) = (-b +- (d)^(1/2)) / (2 x a)

Ademas: 

1. El coeficiente a tiene que ser distinto de 0 para poder realizar el calculo de la  ecuacion
2. El determinante nos dicta 3 casos de soluciones
    - Determinante negativo: La ecuacion no tiene soluciones reales
    - Determinante cero: La ecuacion tiene una sola solucion
    - Determinante positivo: La ecuacion tiene 2 soluciones reales
    
Mostrar al usuario:

1. En caso de a=0 inidicar al usuario el Error matematico
2. Cuantas soluciones reales tiene la ecuacion, de no tener, tambien imprimirlo
3. El determinante de la ecuacion
4. La/las solucion/es de la ecuacion dada*/



import java.util.Scanner;                                                                                              // Se importa la libreria de Scanner para tener entradas comodas

public class N01Ecuacion {                                                                                             // Definicion de la clase
    public static void main(String[] args) {                                                                           // Metodo Main
        Scanner sc = new Scanner(System.in);                                                                           // Se crea un Scanner en la variable sc

// Definicion de variables

        int a,b,c;                                                                                                     // Variables de coeficientes enteras
        double determinante, x, x1,x2 ;                                                                                // Variables de determinante y soluciones

// Tomar informacion de entrada

        System.out.println("~~ ECUACIONES CUADRATICAS\n~~ Ingrese los coeficientes correspondientes de la ecuacion a evaluar."); // Instrucciones al User
        System.out.print("~~ Ingrese el coeficiente (a): ");                                                        // Instrucciones al User
        a = sc.nextInt();                                                                                              // Asignacion de un Scanner al coeficiente a

        System.out.print("~~ Ingrese el coeficiente (b): ");                                                        // Instrucciones al User
        b = sc.nextInt();                                                                                              // Asignacion de un Scanner al coeficiente b

        System.out.print("~~ Ingrese el coeficiente (c): ");                                                        // Instrucciones al User
        c = sc.nextInt();                                                                                              // Asignacion de un Scanner al coeficiente c

//  Primera verificacion y calculo de determinante

        if (a == 0) {                                                                                                  // Verificar que a no sea cero
            System.out.println("~~ El sistema no tiene solucion real con a = 0");                                   // De ser asi se indica que no hay solucion al User
        }
        else{                                                                                                          // Si no, seguir con el programa
            determinante = CalcularDeterminante(a, b, c);                                                              // Se calcula el determinante usando el metodo y los argumentos

// Comparacion de casos del determinante calculado
        
            if (determinante < 0) {                                                                                    // Si el determinante calculado es negativo
                System.out.println("~~ El sistema no tiene soluciones reales");                                     // Indica al User que no hay soluciones reales
            }
            else if (determinante == 0) {                                                                              // Si el determinante es igual a 0
                System.out.println("~~ El sistema tiene una solucion real");                                        // Indica al User la cantidad de soluciones
                System.out.println("~~ El determinante de la ecuacion es: "+determinante);                             // Indica al User el determinante
                x = CalcularSolucionUnica(a, b, c, determinante);                                                      // Usa el metodo con los argumentos y asigna el resultado a x
                System.out.println("~~ Las solucion de la ecuacion se encuentra en x = "+ x);                          // Indica la solucion de la ecuacion al User
            } 
            else {                                                                                                     // Sino, (asume que el determinate es positivo)
                System.out.println("~~ El sistema tiene dos soluciones reales");                                    // Indica al User la cantidad de soluciones
                System.out.println("~~ El determinante de la ecuacion es: "+determinante);                             // Indica al User el determinante
                x1 = CalcularX1(a, b, c, determinante);                                                                // Usa el metodo con los argumentos y asigna el resultado a x1
                x2 = CalcularX2(a, b, c, determinante);                                                                // Usa el metodo con los argumentos y asigna el resultado a x2
                System.out.println("~~ Las soluciones de la ecuacion se encuentran en x1 = "+x1+" x2 = "+x2);          // Indica la solucion de la ecuacion al User
            }
        }
        sc.close();                                                                                                    // Ciera el Scanner
    }

// Metodo para calcular el determinante

    public static double CalcularDeterminante(int a, int b, int c){                                                    // Recibe como parametros los coeficientes 
        double determinanteCalculado;                                                                                  // Variables a usar en el metodo
        determinanteCalculado = (double) ((b*b) - (4 * a * c)) ;                                                       // Calculo matematico de determinante (d) mencionado arriba
        return determinanteCalculado;                                                                                  // Devuelve el calculo del determinante
        }


// Metodo para calcular el caso de solucion unica

    public static double CalcularSolucionUnica(int a, int b, int c, double det){                                       // Recibe como parametros los coeficientes y el determinante
        double x;                                                                                                      // Variables a usar en el metodo
        x = (double) (-b / (2* a));                                                                                    // Calculo de la respuesta unica
        return x;                                                                                                      // Devuelve el calculo de la respuesta unica
    }

// Metodo para calcular el 1er caso de dos soluciones

    public static double CalcularX1(int a, int b, int c, double det ){                                                 // Recibe como parametros los coeficientes y el determinante
        double x1;                                                                                                     // Variables a usar en el metodo
        x1 = (double) ((-b + Math.sqrt(det)) / (2*a)) ;                                                                // Calculo de la respuesta 1 (suma)
        return x1;                                                                                                     // Devuelve el calculo de la 1ra respuesta
    }

// Metodo para calcular el 2do caso de dos soluciones

    public static double CalcularX2(int a, int b, int c, double det ){                                                 // Recibe como parametros los coeficientes y el determinante
        double x2;                                                                                                     // Variables a usar en el metodo
        x2 = (double) ((- b - Math.sqrt(det)) / (2*a)) ;                                                               // Calculo de la respuesta 2 (resta)
        return x2;                                                                                                     // Devuelve el calculo de la 2da respuesta
    }
}
