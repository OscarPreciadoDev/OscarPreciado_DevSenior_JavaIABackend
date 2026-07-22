package EjemploAutomotorV4;

public class ConsAutDemo {

    public static void main(String[] args) {

        // Construye Automotores completos
        Automotor minivan = new Automotor(7,60,6); // Se usa el constructor de la clase Automotor
        Automotor carrodepor = new Automotor(2,50,3);
        double litros ;
        int dist = 252;

        litros = minivan.gasnecesaria(dist);

        System.out.println("Para recorrer " + dist + " kms una minivan necesita " + litros + " litros de gasolina.");

        litros  = carrodepor.gasnecesaria(dist);

        System.out.println("Para recorrer " + dist + " kms un carro deportivo necesita " + litros + " litros de gasolina.");
    }
}
