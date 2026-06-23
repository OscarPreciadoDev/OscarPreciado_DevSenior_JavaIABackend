/*
    Este programa despliega una tabla para convertir pulgadas a metros
*/


public class N14CalculadoraPulgadasAMetros {


    
    public static void main(String args[]){

        double pulgadas, metros;
        int contador;

        contador = 0;

        for(pulgadas=1; pulgadas<=120; pulgadas++){
            metros = pulgadas / 39.37; // Convierte a pulgadas

            System.out.println(">> "+pulgadas+" pulgadas son "+ metros +" metros.");

            contador++;
            // cada 12 lineas, imprime una linea en blanco

            if(contador==12){
                System.out.println();
                contador=0; // Restablece el contador de lineas
            }
        }
    }

}


