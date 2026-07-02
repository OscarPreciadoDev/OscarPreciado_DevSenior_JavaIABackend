// ## SOLO ARRAY

// Crea un array con 5 numeros fijos y recorrelo con un for para imprimir la suma


public class App {
    public static void main(String[] args) throws Exception {
        
        final int[] LISTADENUMEROS = {7,7,7,7,7};
        int suma =0;

        System.out.println("Suma inicial: " + suma);
        for (int i = 0; i < 5; i++){
            
            suma = suma + LISTADENUMEROS[i];
            System.out.println("Paso " + (i+1) + ". " + (suma-LISTADENUMEROS[i]) + " + " + LISTADENUMEROS[i] + " = " + suma );
        }
        System.out.println("Suma final: " + suma);
    }
}
