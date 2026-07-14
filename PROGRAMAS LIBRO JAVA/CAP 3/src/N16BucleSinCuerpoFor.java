// El cuerpo de un bucle puede estar vacío

public class N16BucleSinCuerpoFor {
    public static void main(String[] args) {
        int i;
        int suma = 0;

        // sumar números hasta 5

        for( i = 1; i <= 5 ; suma+= i++); // Bucle sin cuerpo

        System.out.println("La suma es " + suma);
    }
}
