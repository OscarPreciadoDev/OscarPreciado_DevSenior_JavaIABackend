/*
Uso de continue con una etiqueta
 */

public class N29ContinueEtiqueta1 {
    public static void main(String[] args) {
        bucleexterno:
            for(int i = 1; i < 10 ; i++ ) {
                System.out.print("\nPaso de bucle externo " + i + ", Bucle interno: ");
                for (int j = 1; j < 10; j++ ) {
                    if (j == 5) continue bucleexterno; // Continua a bucle externo
                    System.out.print(j);
                }
            }
    }
}
