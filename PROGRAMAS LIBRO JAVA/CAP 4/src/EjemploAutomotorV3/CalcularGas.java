package EjemploAutomotorV3;

public class CalcularGas {
    public static void main(String[] args){

        AutomotorV3 minivan = new  AutomotorV3();
        minivan.tanqueGas = 60;
        minivan.pasajeros = 7;
        minivan.kpl = 6;

        AutomotorV3 carroDeportivo = new  AutomotorV3();
        carroDeportivo.tanqueGas = 50;
        carroDeportivo.pasajeros = 2;
        carroDeportivo.kpl = 4;

        int distancia = 252;

        double gasNeceCarro = carroDeportivo.gasNecesaria(distancia);
        double gasNeceMinivan = minivan.gasNecesaria(distancia);

        System.out.println("La gasolina necesaria de un auto deportivo para recorrer " + distancia + " kilometros. Es de " + gasNeceCarro + " litros.");
        System.out.println("La gasolina necesaria de una minivan para recorrer " + distancia + " kilometros. Es de " + gasNeceMinivan + " litros.");
    }
}
