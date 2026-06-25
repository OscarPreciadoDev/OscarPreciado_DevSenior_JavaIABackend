/*
Juego de adivina la letra

El programa le pregunta al jugador una letra entre la A y la Z
Si el jugador oprime la letra correcta en el teclado
el programa responde imprimiento el mensaje
** Correcto** 
*/

public class N02JuegoAdivinaLaLetra {
    public static void main(String[] args)
    throws Exception{
        char ch , respuesta = 'K';

    System.out.println("~~ Estoy pensando en una letra entre la A y la Z.");
    System.out.print("~~ Puedes adivinar: ");

    ch = (char) System.in.read();

    if (ch == respuesta ) System.out.println("** Correcto **");
    else System.out.println("~~ ...Lo siento, es incorrecta. :(");
    }
}
