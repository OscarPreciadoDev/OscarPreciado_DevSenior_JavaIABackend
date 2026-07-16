package EjemploAutomotorV2;

import EjemploAutomotorV1.AutomotorV1;

public class MainAutomotorV2 {

    public static void main(String[] args) {

        // Se instancia un objeto de la clase automotor
        AutomotorV2 minivan = new AutomotorV2();
        AutomotorV2 carroDeportivo = new AutomotorV2();

        // Variable donde se almacenara el total de km que puede recorrer un Automotor de manera autonoma

        double rango1, rango2;

        // Se accede a un miembro (atributo o variable de instancia) de minivan usando (objeto.miembro) y se asigna.

        minivan.tanqueGas = 60;
        minivan.pasajeros = 7;
        minivan.kpl = 6;

        carroDeportivo.tanqueGas = 50;
        carroDeportivo.pasajeros = 2;
        carroDeportivo.kpl = 4;



        //Calcula el rango suponiendo un tanque lleno de gas (OBSOLETO!!)

        rango1 = minivan.rango();
        rango2 = carroDeportivo.rango();


        // Imprime un mensaje en consola

        System.out.print("Una minivan puede transportar " + minivan.pasajeros + " pasajeros. ");
        System.out.println("Tiene un rendimiento de " + rango1 + " kilometros.");

        System.out.print("Un carro deportivo puede transportar " + carroDeportivo.pasajeros + " pasajeros. " );
        System.out.println("Tiene un rendimiento de " + rango2
                + " kilometros.");
    }

}