/*  Pedir el radio de un circulo y calcular su area.
    A = pi*r^2

    Tener presente
    1. El area ingresada no deberia ser un numero negativo
    */

import java.util.Scanner;

public class N02RadioCirculo {
    public static void main(String[] args) {
        double radio, area;
        Scanner sc = new Scanner(System.in);
        System.out.println("*** AREA DE UN CIRCULO ***");
        System.out.print("Ingrese el radio del circulo: ");
        radio = sc.nextDouble();

        if (radio >= 0) {
            area = calcularArea(radio);
            System.out.println("El area del circulo es: " + area);
        } 
        else{
            System.out.println("El radio no puede ser negativo.");
        }

        sc.close();
    }

    public static double calcularArea(double radio){

        double area = (Math.PI) * (radio*radio);

        return area;
    }
}

