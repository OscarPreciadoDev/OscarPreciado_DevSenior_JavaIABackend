package EjemploAutomotorV3;

public class AutomotorV3 {

    // Declaración de variables de instancia (atributos)

    int pasajeros;  // Número de pasajeros
    int tanqueGas;  // Capacidad del tanque en litro
    int kpl;        // Consumo de gasolina km/litro

    // Un metodo que calcula el rango total de kilómetros de autonomía
    // que tiene un automotor

    double rango(){
        return kpl * tanqueGas;
    }

    // Un metodo que calcular la cantidad de gasolina necesaria para recorrer una
    // distancia determinada. A este nuevo metodo se le llamara gas necesaria()
    // Este metodo toma el número de kilómetros que quiere manejar y devuelve
    // el número de litros requeridos de gasolina.

    double gasNecesaria(int kilometros) {
        return (double) kilometros / kpl;
    }
}