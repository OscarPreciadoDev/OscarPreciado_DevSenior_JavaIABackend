/*
Demostracion del uso de continue
 */

public class N28ContinueDemo {
    public static void main(String[] args) {
        int i;

        //Imprime los numeros pares entre 0 y 100
        for (i = 0; i <= 100; i++) {
            if ((i%2) != 0) continue; // Itera omitiendo las siguientes instrucciones.
            System.out.println(i);
        }
    }
}
