/*
Inicializa una matriz de dos dimensiones
 */

package MATRICES;

public class Cuadrados {

    public static void main(String[] args) {
        int[][] cuads = {
                {1,1},
                {2,4},
                {3,9},
                {4,16},
                {5,25},
                {6,36},
                {7,49},
                {8,64},
                {9,81},
                {10,100}
        };

        int i,j;

        for(i=0; i<10; i++){
            for(j=0; j<2 ; j++) System.out.print(cuads[i][j] + " ");
            System.out.println();
        }

    }

}

/*
SALIDA DEL PROGRAMA
1 1
2 4
3 9
4 16
5 25
6 36
7 49
8 64
9 81
10 100
 */