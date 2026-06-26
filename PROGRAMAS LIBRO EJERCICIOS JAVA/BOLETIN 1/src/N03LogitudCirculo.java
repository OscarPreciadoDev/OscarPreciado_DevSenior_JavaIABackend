/* Pedir el radio de una circunferencia y calcular su longitud

Notaciones:
1. El radio dado no puede ser negativo
2. El calculo de la longitud (diametro) se calcula de 
    diametro = 2 x Pi x r
 */

import java.util.Scanner;

public class N03LogitudCirculo {
    public static void main(String[] args) {
        
        double radio, diametro;
        Scanner sc = new Scanner(System.in);

        System.out.println("*** LONGITUD DE UN CIRCULO");
        System.out.print( "Ingrese el radio de la circunferencia: ");
        radio = sc.nextDouble();

        diametro = calcularLongitud(radio);
        System.out.printf("La longitud de una circunferencia con radio: " + radio + " es: %.2f%n" , diametro);
        sc.close();
    }
    public static double calcularLongitud(double radio){
        double diametro = 2*Math.PI*radio;
        return diametro;
    }
}
