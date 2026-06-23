/*
    Si cronometra el eco podra calcular la distancia que lo separa de un objeto grande, como una pared de roca, Por ejemplo si aplaude y mide cueanto tiempo le toma escuchar el eco, entonces sabra el tiempo total de ida y vuelta. Al dividir este valor entre dos se obtiene el tiempo que tomo el sonido en ir en un sentido, Luego puede usar ese valor para calcular la distancia hacia el objeto.*/

public class N16DistanciaConEco {
    public static void main(String[] args) {
        
        double tiempo = 7.2;

        double distancia = ( tiempo / 2 ) * 340;

        System.out.println(">> El true se encuentra a "+distancia+" metros de distancia.");

    }
}