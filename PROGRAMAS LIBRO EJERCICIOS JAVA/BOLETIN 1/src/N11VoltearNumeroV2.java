import java.util.Scanner;

public class N11VoltearNumeroV2 {

    public static void main(String[] args) {

        boolean run = true;
        Scanner input = new Scanner(System.in);
        int numEntrada;

        String encabezado = ("=".repeat(50)+"\n\t\t\tINVERSOR DE NUMEROS\n"+"=".repeat(50));
        String instruccion = ("\nIngrese un numero para invertirlo, debe estar entre 0 y 99999\n");
        String pieDePrograma =("\n"+"=".repeat(50)+"\n\t\t\tFIN DEL PROGRAMA\n"+"=".repeat(50));
        String mensajeNumeroErroneo = "ERROR: el numero ingresado esta fuera del rango.";
        String preguntaEjecucion = "Desea ingresar una nuevo Numero? | (1) SI | (2) NO | ---> ";

        System.out.println(encabezado);
        do {
            System.out.println(instruccion);
            numEntrada = Validador.leerEntero(input, "Ingrese un numero: ");
            if (validarNumero(numEntrada)){
                invertirNumero(numEntrada);
            } else {
                System.out.println(mensajeNumeroErroneo);
            }

            run = Validador.continuacionDelPrograma(input, preguntaEjecucion);

        } while (run);

        System.out.println(pieDePrograma);

    }


    private static void invertirNumero(int num) {
        int tamanioNum = String.valueOf(num).length();

        System.out.print("\nEl numero " + num + " invertido es ");

        for (int i = 0 ; i < tamanioNum ; i++){
            int numPrint = num % 10;
            num /= 10;
            System.out.print(numPrint);
        }
        System.out.println("\n");

    }

    public static boolean validarNumero(int num){
        return (num>= 0 && num <= 9999);
    }

}
