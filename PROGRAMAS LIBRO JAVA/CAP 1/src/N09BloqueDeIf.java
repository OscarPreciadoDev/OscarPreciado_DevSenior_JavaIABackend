/*
    Demuestre un bloque de codigo.
*/

public class N09BloqueDeIf {
    public static void main(String args []){

        double i,j,d;

        i = 5;
        j = 10;

        // el destino de este if es un bloque

        if (i!=0){
            System.out.println(">> i no es igual a cero");
            d = j/i;
            System.out.println(">> j / i es igual a : " + d);
        } 
    }
}
