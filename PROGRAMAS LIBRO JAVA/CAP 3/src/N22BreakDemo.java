/*
Este programa demuestra el uso de break para salir de un bucle
 */

public class N22BreakDemo {
    public static void main(String[] args) {
        int num = 100;

        // recorre el bucle si i al cuadrado es menor que num

        for(int i = 0; i < num; i++) {
            if (i * i >= num) break;  // termina el bucle si i al cuadrado es mayor o igual que 100
            System.out.print(i + " ");
        }
            System.out.println("Bucle completo.");
    }
}
