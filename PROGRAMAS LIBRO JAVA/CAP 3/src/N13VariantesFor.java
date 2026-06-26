// Partes de for pueden estar vacias

public class N13VariantesFor {
    public static void main(String[] args) {
        int i;

        for(i = 0; i <= 10;){ // Falta la expresion de iteracion
            System.out.println("Paso #" + i);
            i++;
        }
    }
}
