// Ejemplo donde se agrega un constructor

package EjemploAutomotorV4;

public class Automotor {
    // Atributos
    int pasajeros, tanquegas, kpl;

    // Constructor para Automotor
    Automotor(int p, int t, int k){
        pasajeros = p;
        tanquegas = t;
        kpl = k;
    }

    // Metodo que calcula el rango de autonomia del Automotor
    int rango (){
        return kpl * tanquegas;
    }

    // Metodo que calcula la gasolina necesaria para una distancia dada
    double gasnecesaria(int km) {
        return (double) km / kpl;
    }

}