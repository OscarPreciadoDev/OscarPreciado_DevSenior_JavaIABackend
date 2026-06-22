/*
    Pide un dia de la semana como texto e imprime "Laboral" o "fin de semana" segun corresponda, usando un switch sobre String.
*/ 

import java.util.Scanner;

public class EjercicioSwitchString {
    public static void main(String[] args) {
        
        String diaIngresado;

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un dia de la semana: ");
        diaIngresado = sc.nextLine();

        switch (diaIngresado) {
            case ("lunes"):
                System.out.println("Laboral");
                break;
            case "martes":
                System.out.println("Laboral");
                break;
            case "miercoles":
                System.out.println("Laboral");
                break;
            case "jueves":
                System.out.println("Laboral");
                break;
            case "viernes":
                System.out.println("Laboral");
                break;
            case "sabado":
                System.out.println("Fin de semana");
                break;
            case "domingo":
                System.out.println("Fin de semana");
                break;
            default:
                System.out.println("Entrada Invalida");
                break;
        }
        sc.close();
    }
}
