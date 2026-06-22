/*
    Pide un precio con decimales (nextDouble()) y muestralo redondeado hacia abajo convirtiendolo a int. Explica que paso con los decimales
*/

import java.util.Scanner;

public class EjercicioConversionDeTipos {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        double ingreso;

        System.out.print("Ingrese un precio: ");
        ingreso = sc.nextDouble();

        int ingresoRedondeado = (int) ingreso;

        System.out.println("Precio redondeado hacia abajo: "+ ingresoRedondeado);

        sc.close();  

    }
}
