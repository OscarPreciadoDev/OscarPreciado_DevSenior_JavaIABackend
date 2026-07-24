/*
El siguiente programa es una demostracion basica del uso de una Matriz de una dimension.
 */

package MATRICES;

class MatrizDemo {
    public static void main(String[] args){

        int[] muestra = new int[10];
        int i;

        // Usando un ciclo se recorren las casillas de la matriz y se asigna un número incremental manejado por i.
        for (i=0;i<10;i++){
            muestra[i]=i;
        }

        // Usando un ciclo se imprime una parte del proceso interno de recorrer la lista0
        for (i=0;i<10;i++){
            System.out.println("Muestra[" + i  + "]: " + muestra[i]);
        }

    }
}

/* SALIDA DEL PROGRAMA
Muestra[0]: 0
Muestra[1]: 1
Muestra[2]: 2
Muestra[3]: 3
Muestra[4]: 4
Muestra[5]: 5
Muestra[6]: 6
Muestra[7]: 7
Muestra[8]: 8
Muestra[9]: 9
 */