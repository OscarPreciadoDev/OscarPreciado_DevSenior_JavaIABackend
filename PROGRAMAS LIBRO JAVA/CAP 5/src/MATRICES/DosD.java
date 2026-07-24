/*
El siguiente programa demuestra una matriz de dos dimensiones.
 */


package MATRICES;

public class DosD {
    public static void main(String[] args){
        int t,i;

        int[][] tabla = new int[3][4];

        for(t=0;t<3;++t){
            for(i=0;i<4;++i){
                tabla[t][i]=(t*4)+i+1;
                System.out.print(tabla[t][i]+" ");
            }
            System.out.println();
        }
    }
}

/*
SALIDA DEL PROGRAMA

1  2  3  4
5  6  7  8
9 10 11 12

 */
