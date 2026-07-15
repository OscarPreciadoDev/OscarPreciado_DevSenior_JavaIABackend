/*
Demostración uso de break con etiquetas ejemplo 1
 */
public class N25BreakEtiqueta1 {

    public static void main(String[] args){
        int i;

        for (i = 1 ; i < 4 ; i++ ) {
            uno: {
            dos: {
            tres:{
                System.out.println("\ni es " + i);
                if (i == 1) break uno;
                if (i == 2) break dos;
                if (i == 3) break tres;
                // este nunca se alcanza
                System.out.println("No se imprime");
                    }
                System.out.println("Tras el bloque tres.");
                }
            System.out.println("Tras el bloque dos.");
            }
        System.out.println("Tras el bloque uno.");
        }
    System.out.println("Tras el bucle for.");
    }
}
