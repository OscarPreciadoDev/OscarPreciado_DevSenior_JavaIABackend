/*
Demostración uso de break con etiquetas ejemplo 2
 */

public class N26BreakEtiqueta2 {
    public static void main(String[] args) {
        hecho:
            for (int i = 0 ; i < 10 ; i++ ) {
                for (int j = 0 ; j < 10 ; j++ ){
                    for (int k = 0 ; k < 10 ; k++) {
                        System.out.println(k + " ");
                        if (k == 5 ) break hecho; // Salta a hecho
                    }
                    System.out.println("Tras el bucle k."); // No se ejecuta
                }
            System.out.println("Tras el bucle j."); // No se ejecuta
            }
        System.out.println("Tras el bucle i.");
    }
}
