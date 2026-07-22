/*
Pedir un numero entre 0 y 9999 y decir si es capicua
 */


import java.util.Scanner;

public class N12NumeroCapicua {
    public static void main(String args[]) {

        boolean run = true;
        Scanner input = new Scanner(System.in);
        int numEntrada;

        String encabezado = ("=".repeat(50)+"\n\t\t\tVERIFICADOR DE NUMERO CAPICUA\n"+"=".repeat(50));
        String instrucciones = ("\nIngrese un numero para verificar si es capicua, debe estar entre 0 y 9999\n");
        String pieDePrograma = ("\n"+"=".repeat(50)+"\n\t\t\tFIN DEL PROGRAMA\n"+"=".repeat(50));
        String mensajeNumeroErroneo = "ERROR: el numero ingresado esta fuera del rango.";
        String  PreguntaEjecucion =  "\nDesea ingresar una nuevo Numero? | (1) SI | (2) NO | ---> ";

        System.out.println(encabezado);
        do{
            System.out.println(instrucciones);
            numEntrada = Validador.leerEntero(input, "Ingrese un numero: ");
            if (validarNumero(numEntrada)) {
                lanzarMensajeCapicua(numEntrada);
            } else {
                System.out.println(mensajeNumeroErroneo);
            }


            run = Validador.continuacionDelPrograma(input,PreguntaEjecucion);

        } while (run);


       input.close();
        System.out.println(pieDePrograma);

    }

    public static boolean validarNumero(int num){
        return (num>= 0 && num <= 99999);
    }

    public static void lanzarMensajeCapicua(int num){

        String numString = Integer.toString(num);

        int caracteres = numString.length();

        // Caso numeros pares
        if (caracteres == 1) System.out.println("El numero " + num + " es capicua.");
        else if (caracteres == 2) {
            if (numString.charAt(1) == numString.charAt(0)){
                System.out.println("El numero " + num + " es capicua.");
            }
            else {
                System.out.println("El numero " + num + " no es capicua.");
            }
        } else if (caracteres == 3) {
            if(numString.charAt(0) == numString.charAt(2)){
                System.out.println("El numero " + num + " es capicua.");
            }
            else {
                System.out.println("El numero " + num + " no es capicua.");
            }
        }
        // Se asume un tamanio de 4 caracteres
        else {
            if ((numString.charAt(0) == numString.charAt(3))&&(numString.charAt(1) == numString.charAt(2))){
                System.out.println("El numero " + num + " es capicua.");
            }
            else {
                System.out.println("El numero " + num + " no es capicua.");
            }
        }

    }
}
