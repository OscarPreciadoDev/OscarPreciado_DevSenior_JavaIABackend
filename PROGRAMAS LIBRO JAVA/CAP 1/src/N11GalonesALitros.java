/*
    Proyecto 1.1

    Este programa convierte galones en litros.

*/

public class N11GalonesALitros {
    public static void main(String arg[]){
        double galones; // contiene la cantidad de galones
        double litros; // contiene lo convertido a litros

        galones = 10; // empieza con 10 galones

        litros = galones * 3.7584; // convierte a litros

        System.out.println(galones + " galones son " + litros + " litros.");
    }
}