/*
El siguiente programa demuestra el uso de bucles anidados
usando de ejemplo para encontrar los factores del 2 al 100.
 */

public class N31BucleFinal {
    public static void main(String[] args){
        for(int i = 2; i <= 100 ; i++ ){
            System.out.print("Factores de " + i + ": ");

            for(int j = 2; j < i ; j++)
                if ((i%j) == 0 ) System.out.print(j + " ");

            System.out.println();

        }
    }
}
