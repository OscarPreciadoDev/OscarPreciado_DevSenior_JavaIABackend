package EjemploAutomotorV1;

public class MainAutomotorV1 {

    public static void main(String[] args) {

        // Se instancia un objeto de la clase automotor
        AutomotorV1 minivan = new AutomotorV1();
        AutomotorV1 carroDeportivo = new AutomotorV1();

        // Variable donde se almacenara el total de km que puede recorrer un Automotor de manera autonoma

        // int rango1, rango2; (OBSOLETO !!)

        // Se accede a un miembro (atributo o variable de instancia) de minivan usando (objeto.miembro) y se asigna.

        minivan.tanqueGas = 60;
        minivan.pasajeros = 7;
        minivan.kpl = 6;

        carroDeportivo.tanqueGas = 50;
        carroDeportivo.pasajeros = 2;
        carroDeportivo.kpl = 4;


        /*
        Calcula el rango suponiendo un tanque lleno de gas (OBSOLETO!!)

        rango1 = minivan.tanqueGas * minivan.kpl;
        rango2 = carroDeportivo.tanqueGas * carroDeportivo.kpl;
         */

        // Imprime un mensaje en consola

        System.out.print("Una minivan puede transportar " + minivan.pasajeros + " pasajeros. ");
        minivan.rango();

        System.out.print("Un carro deportivo puede transportar " + carroDeportivo.pasajeros + " pasajeros. " );
        carroDeportivo.rango();
    }

}
