/*
El siguiente programa es una demostracion del uso de
ordenamiento por el metodo burbuja, utilizado para organizar elementos de una matriz
 */

package MATRICES;

public class Burbuja {
    public static void main(String[] args){

        // Un arreglo sin orden
        int[] nums = { 99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49};

        int a,b,t;
        int dimen;

        dimen = 10; // Número de elementos para ordenar (Tamaño del arreglo)

        // despliega la matriz original
        System.out.print("La matriz original es: ");
        for(int i = 0; i < dimen; i++)System.out.print(" " + nums[i]);
        System.out.println();

        // Este es el orden de burbuja.
        for (a=1; a < dimen ; a++){
            for (b=dimen-1; b>= a; b--){
                if(nums[b-1] > nums[b] ){ // Si está fuera de orden (elemento anterior mayor al actual)
                    //intercambia elementos
                    t = nums[b-1];
                    nums[b-1] = nums[b];
                    nums[b] = t;
                }
            }
        }

        // despliega la matriz organizada
        System.out.print("La matriz organizada es: ");
        for(int i = 0; i < dimen; i++) System.out.print(" " + nums[i]);
        System.out.println();
    }
}

/*
SALIDA DEL PROGRAMA:

La matriz original es:  99 -10 100123 18 -978 5623 463 -9 287 49
La matriz organizada es:  -978 -10 -9 18 49 99 287 463 5623 100123


 */

