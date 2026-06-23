// Demuestra la vida de una variable.

public class N07VidaVariablesDemo {

    public static void main(String[] args) {
        
        int x;

        for (x=0; x<3; x++) {

            int y = -1;                          // y se inicializa cada que entre al bloque 
            System.out.println("y es: " + y);    // siempre imprime -1
            y = 100;
            System.out.println("y es ahora: "+ y);
        }
    }
}
