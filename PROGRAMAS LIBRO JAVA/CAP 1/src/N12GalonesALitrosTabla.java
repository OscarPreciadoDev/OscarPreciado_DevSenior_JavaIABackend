/*
    Proyecto 1.2

    Este programa despliega una tabla para convertir galones a litros.
*/

public class N12GalonesALitrosTabla {
    public static void main(String args[]){

        double galones, litros;
        int contador;

        contador = 0;

        for(galones=1; galones<=100; galones++){
            litros = galones * 3.7854; // Convierte a litros

            System.out.println(">> "+galones+" galones son "+litros+" litros.");

            contador++;
            // cada 10 lineas, imprime una linea en blanco

            if(contador==10){
                System.out.println();
                contador=0; // Restablece el contador de lineas
            }
        }
    }
}