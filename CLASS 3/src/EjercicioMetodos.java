/*
    crea un metodo esPar (int numero) que devuelva true si el numero es par y false si no. Pruebalo con 3 numeros desde el main.
*/

import java.util.Scanner;

public class EjercicioMetodos {

    
    public static void main(String[] args) {
        
        int numeroEntrada;

        Scanner sc= new Scanner(System.in);

        for (int i=1; i<=3; i++){
            System.out.print("Ingrese un numero: ");
            numeroEntrada = sc.nextInt();
            
            System.out.println("El numero " + numeroEntrada + " es par? : " + esPar(numeroEntrada));
            }
        
        sc.close();
        }

    public static boolean esPar(int numero){
        if (numero % 2 == 0){
            return true;
        } else {return false;}
    }
}
