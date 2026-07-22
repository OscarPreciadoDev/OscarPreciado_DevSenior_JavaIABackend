/*
Pedir el día, mes y año de una fecha e indicar si la fecha es correcta. Suponiendo todos los meses de 30 días.
 */

import java.util.Scanner;

public class N14VerificadorDeFecha {
    public static void main(String[] args){

        boolean run = true;
        Scanner input = new Scanner(System.in);
        int dia,mes,anio;

        String encabezado ="=".repeat(50)+"\n\t\t\tFORMATEADOR DE FECHA\n"+"=".repeat(50);
        String instrucciones ="\nIngrese un dia, un mes y un año para formatear dicha fecha ingresada.\n(debe ingresar valores logicos dentro de lo que comprenden las fechas)";
        String pieDePrograma ="\n"+"=".repeat(50)+"\n\t\t\tFIN DEL PROGRAMA\n"+"=".repeat(50);
        String PreguntaEjecucion ="\nDesea ingresar una nuevo Numero? | (1) SI | (2) NO | ---> ";

        System.out.println(encabezado);
        do {
            System.out.println(instrucciones);
            dia = leerDia(input, "Ingrese un dia: ");
            mes = leerMes(input, "Ingrese un mes: ");
            anio = leerAnio(input, "Ingrese un año: ");
            if (validarFecha(dia,mes)){
                imprimirFecha(dia,mes,anio);
            } else {
                errorFecha(dia,mes);
            }


            run = Validador.continuacionDelPrograma(input,PreguntaEjecucion);

        } while (run);

        System.out.println(pieDePrograma);

    }

    public static int leerDia(Scanner input, String mensaje){
        while (true) {
            int dia = Validador.leerEntero(input, mensaje);
            if (dia>=1 && dia<=31) return dia;
            else System.out.println("ERROR: El dia ingresado debe estar entre 1 y 30.");
        }

    }

    public static int leerMes(Scanner input, String mensaje){
        while (true) {
            int mes = Validador.leerEntero(input, mensaje);
            if (mes >= 1 && mes <= 12) return mes;
            else System.out.println("ERROR: El mes ingresado debe estar entre 1 y 12.");
        }
    }

    public static int leerAnio(Scanner input, String mensaje){
        while (true) {
            int anio = Validador.leerEntero(input, mensaje);
            if (anio >= 0 && anio <=100000) return anio;
            else System.out.println("ERROR: El anio ingresado debe estar entre 1 y 100000.");
        }
    }

    public static void imprimirFecha(int dia,int mes,int anio){
        String[] nombreMes = {
                "Enero",
                "Febrero",
                "Marzo",
                "Abril",
                "Mayo",
                "Junio",
                "Julio",
                "Agosto",
                "Septiembre",
                "Octubre",
                "Noviembre",
                "Diciembre"
        };
        System.out.println(dia+" / "+ nombreMes[mes-1] +" / "+anio);
    }

    public static boolean validarFecha(int dia,int mes){
        if (mes == 2 && dia < 28) return false;
        else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 20) return false;
        else return true;
    }

    public static void  errorFecha(int dia,int mes){
        if (mes == 2 ){
            System.out.println("El mes de febrero solo tiene 28 dias.");
        } else if (mes == 4){
            System.out.println("El mes de abril solo tiene 30 dias.");
            PENDIENTE AQUIIIIIIIIIIIIII

        }
    }

}

