/*
    Este programa ilustra las diferencias entre int y double
*/

public class N06EnterosYDecimales {
    public static void main(String args[]){

        int var; // declara una variable entera
        double x; // declara una variable de punto flotante

        var = 10; // Asigna 10 a la variable var

        x = 10.0; // Asigna 10.0 a la variable x

        System.out.println(">> Valor original de var: " + var);
        System.out.println(">> Valor original de x: " + x);

        System.out.println(); // Imprime una linea en blanco

        // Ahora divide ambos entre 4
        var = var/4;
        x = x/4;

        System.out.println(">> Valor dividido de var: " + var); // 2 <- Valor decimal perdido
        System.out.println(">> Valor dividido de x: " + x); // 2.5 <- Valor decimal preservado


    }
}
