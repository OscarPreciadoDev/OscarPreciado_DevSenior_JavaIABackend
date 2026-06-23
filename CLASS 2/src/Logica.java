/*
    Combinamos condiciones con AND, OR y NOT sobre datos de un cliente
*/

public class Logica {
    
    public static void main(String[] args) {
        
        int edad = 20;
        boolean tieneCedula = true;

        System.out.println(edad >= 18 && tieneCedula); // True (ambas condiciones son verdaderas)

        boolean esFinDeSemana = false;
        boolean esFestivo = true;

        System.out.println(esFinDeSemana || esFestivo ); // True (al menos una condicion es verdadera)

        System.out.println(!tieneCedula); // False (invierte el valor original)
    }

}
