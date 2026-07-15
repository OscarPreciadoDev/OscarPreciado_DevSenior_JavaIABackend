/*
Demostración uso de break con etiquetas ejemplo 3
 */

public class N27BreakEtiqueta3 {
    public static void main(String[] args) {
        int x = 0, y = 0;

        // aquí se pone la etiqueta antes de la instrucción for.

        alto1:
        for (x = 0; x < 5; x++) {
            for (y = 0; y < 5; y++) {
                if (y == 2) break alto1;
                System.out.println("x , y : " + x + " " + y);
            }
        }

        System.out.println();

        // Ahora, se pone la etiqueta antes de {
        for (x = 0; x < 5; x++)
            alto2:{
                for (y = 0; y < 5; y++) {
                    if (y == 2) break alto2;
                    System.out.println("x , y : " + x + " " + y);
                }
            }

    }
}
