/*
    Pide si el usuario tiene licencia (true/false) y su edad. Imprime "Puede conducir" solo si tiene licencia Y es mayor de 18
*/

import java.util.Scanner;

public class EjercicioOperadoresLogicos {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean tieneLicencia;
        int edad;

        System.out.print("Tiene licencia de conduccion? (true/false): ");
        tieneLicencia = sc.nextBoolean();

        System.out.print("Ingrese su edad: ");
        edad = sc.nextInt();

        if (puedeConducir(tieneLicencia,edad)){
            System.out.println("Puede conducir");
        } else {
            System.out.println("No puede conducir");
        }

        sc.close();
    }

    public static boolean puedeConducir(boolean licencia, int edad) {
        if (licencia && edad >= 18){
            return true;
        } else {return false;}
    }

}
