/*
El siguiente programa encuentra los valores maximos y minimos de una matriz recorriendola usando el metodo de index.
 */

package MATRICES;

public class MinMax {
    public static void main(String[] args){
        int[] nums = new int[10]; // Se declara el arreglo con un tamaño para 10 enteros
        int min,max; // variables

        // Se asignan diversos valores a cada int de la matriz
        nums[0]=99;
        nums[1]=-10;
        nums[2]=100123;
        nums[3]=18;
        nums[4]=-978;
        nums[5]=5623;
        nums[6]=463;
        nums[7]=-9;
        nums[8]=287;
        nums[9]=49;

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
