
// Juego de adivinar la letra 3a version.

public class N04JuegoAdivinaLaLetraV2 {
    public static void main(String[] args) throws Exception {
        
        char ch, respuesta = 'K';

        System.out.println("~~ Esto pensando en una letra entre la A y la Z.");
        System.out.print("~~ Puedes adivinarla: ");

        ch = (char) System.in.read();

        if (ch == respuesta){
            System.out.println("** CORRECTO **");
        } 
        else {
            System.out.print("~~.. Lo siento te encuentras");
            if (ch > respuesta) {
                System.out.println(" demasiado alto");
            }
            else {
                System.out.println(" demasiado bajo");
            }
        }    


    }
}
