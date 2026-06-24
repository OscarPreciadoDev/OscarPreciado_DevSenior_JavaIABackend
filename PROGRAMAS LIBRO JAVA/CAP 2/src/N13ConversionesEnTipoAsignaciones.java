/* Cuando un tipo de dato se asigana otro tipo de varialble
Una conversion automatica de tipo dentra lugar si

Los dos tipos son compatibles
El tipo de destino es mas grande que el tipo de origen*/

//Demuestra la conversion automatica de long a double

public class N13ConversionesEnTipoAsignaciones {
    public static void main(String[] args) {
        
        long L;
        double D;

        L = 100123185L;
        D = L;

        System.out.println("L y D:" + L + " " + D);

    }
}
