// El siguiente programa es un juego interactivo por consola en el cual el usuario debe ingresar una letra, el juego terminara cuando el usuario ingrese la tecla indicada

import java.util.Scanner;

public class N20JuegoAdivinanzaV4 {
    public static void main(String[] args){
        char ch, respuesta = 'K';
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Estoy pensando en una letra entre la A y la Z.");
            System.out.print("Puedes adivinarla: ");
            ch = sc.next().charAt(0);

            if (ch == 'K') {
                System.out.println("*** CORRECTO ***");
            } else if (ch > respuesta){
                System.out.println("Estas demasiado arriba.");
                System.out.println("Intenta nuevamente.\n");
            } else {
                System.out.println("Estas demasiado abajo.");
                System.out.println("Intenta nuevamente.\n");
            }
        } while (ch != 'K');

        sc.close();
    }
}
