/*
El siguiente programa es una version mejorada de MinMax.java en el cual se
optimiza la asignacion de los espacios dentro de la matriz nums
usando los inicializadores de matriz
*/

package MATRICES;

public class MinMax2 {

    public static void main(String[] args){
        int[] nums = { 99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49 };
        int min, max;

        // Se asignan a la primera casilla las variables max y min
        min = max = nums[0];
        for(int i=1; i<10; i++){
            // Durante el recorrido si un número es menor al minimo, se asigna este valor a la variable de minimo
            if(nums[i] < min ) min = nums[i];
            // Durante el recorrido si un número es mayor al maximo, se asigna este valor a la variable de maximo
            if(nums[i] > max) max = nums[i];
        }

        System.out.println("Minimo y maximo: " + min + " " + max);

    }

}

/*
    SALIDA DEL PROGRAMA
    Minimo y maximo: -978 100123
*/
