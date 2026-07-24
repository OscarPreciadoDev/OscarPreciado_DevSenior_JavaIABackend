/*
El siguiente programa demuestra el siguiente ejemplo de campo de estudio:
Un programa que almacena el número de pasajeros que embarcan en un transbordador del aeropuerto.
Si el transbordador funciona 10 veces al día entre semana y dos veces al día los sábados y domingos.
Podría usar la matriz pasajera para almacenar la información. Observe que la longitud de la segunda dimension
para los primeros 5 índices es 10, y la longitud de la segunda dimension para los últimos dos índices es 2.
 */

package MATRICES;

public class Desigual {
    public static void main(String[] args){

        // Matriz que tomara 7 días de la semana, y dentro de cada una matriz de cantidad de pasajeros abordados

        int[][] pasajeros= new int[7][];

        // Los primeros 5 días de la semana tendran espacio para 10 viajes
        pasajeros[0] = new int[10];
        pasajeros[1] = new int[10];
        pasajeros[2] = new int[10];
        pasajeros[3] = new int[10];
        pasajeros[4] = new int[10];

        // Los dos ultimos días tendran espacio para 2 viajes
        pasajeros[5] = new int[2];
        pasajeros[6] = new int[2];

        int i, j;

        // Fabrica algunos datos falsos

        // Rellena con datos falsos los viajes entre semana
        for(i=0; i<5; i++)
            for(j=0; j<10; j++)
                pasajeros[i][j] = i+j+10;

        // Rellena con datos falsos los vaijes del fin de semana
        for(i=5; i<7; i++)
            for(j=0; j<2; j++)
                pasajeros[i][j] = i+j+10;

        // Recorre el arreglo imprimiento los datos rellenados en cada casilla anteriormente
        System.out.println("pasajeros por viaje entre semana:");
        for(i=0; i<5; i++){
            for(j=0; j<10; j++) System.out.print(pasajeros[i][j] + " ");
            System.out.println();
        }
        System.out.println();

        // Recorre el arreglo imprimiento los datos rellenados en cada casilla anteriormente
        System.out.println("Pasajeros por viaje el fin de semana: ");
        for(i=5; i<7; i++){
            for(j=0; j<2; j++) System.out.print(pasajeros[i][j] + " ");
            System.out.println();
        }
        System.out.println();
        }

}

/*
SALIDA DEL PROGRAMA
pasajeros por viaje entre semana:
10 11 12 13 14 15 16 17 18 19
11 12 13 14 15 16 17 18 19 20
12 13 14 15 16 17 18 19 20 21
13 14 15 16 17 18 19 20 21 22
14 15 16 17 18 19 20 21 22 23

Pasajeros por viaje el fin de semana:
15 16
16 17
 */
