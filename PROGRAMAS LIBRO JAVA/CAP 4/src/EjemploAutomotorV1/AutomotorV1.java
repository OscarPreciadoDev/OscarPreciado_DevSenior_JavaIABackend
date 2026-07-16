package EjemploAutomotorV1;

public class AutomotorV1 {

    // Declaración de variables de instancia (atributos)

    int pasajeros;  // Número de pasajeros
    int tanqueGas;  // Capacidad del tanque en litro
    int kpl;        // Consumo de gasolina km/litro

    // Metodo que calcular el rango de autonomía del automotor

    void rango(){
        System.out.println("El rango es " + (tanqueGas * kpl) + " kilometros.");
    }

}
