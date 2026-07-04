/*
    Compararemos una edad contra 18 y guardamos el resultado de la comparacion en una variable 'boolean'

*/

public class Comparacion {
    public static void main(String[] args) {
        
    int edad = 20;

    System.out.println(edad >= 18); // true

    System.out.println(edad == 18); // false

    System.out.println(edad != 18); // true

    boolean esMayorDeEdad = edad >= 18; 

    System.out.println(">> ¿Es mayor de edad? " + esMayorDeEdad);

    }
}
