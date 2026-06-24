// Los efectos colaterales pueden ser importantes.

public class N12EfectosColaterales {
    public static void main(String[] args) {
        int i;

        i = 0;

        /* Aqui, i todavia se incrementa aunque falle la instruccion if. */

        //if (false & (++i < 100))                  // <<=== Quitar comentario para ejecutar
            System.out.println("Esto no se despliega");
        System.out.println("Las instrucciones if se ejecutan: " + i);  // despliega 1

        // En este caso, i no se incrementa porque el operador de cortocircuito salta el incremento.

        //if (false && (++i < 100))                 // <<=== Quitar comentario para ejecutar
            System.out.println("Esto no se despliega");
        System.out.println("Las instrucciones de if se ejecutan: " + i);
    }
}
