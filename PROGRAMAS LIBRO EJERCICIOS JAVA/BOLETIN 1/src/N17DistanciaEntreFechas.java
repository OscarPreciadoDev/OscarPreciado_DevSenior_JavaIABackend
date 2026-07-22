/*
Pedir dos fechas y mostrar el número de días que hay de diferencia. Suponiendo todos los meses de 30 días.
 */

import java.util.Scanner;

public class N17DistanciaEntreFechas {
    static void main(String[] args) {

        boolean run = true;
        Scanner input = new Scanner(System.in);
        int dia1, mes1, anio1, dia2, mes2, anio2;

        String encabezado = "=".repeat(50) + "\n\t\t\tDISTANCIA ENTRE DIAS\n" + "=".repeat(50);
        String instrucciones = "\nIngresa dos fechas, el programa regresara la distancia de dias entre ellas.\n(debe ingresar valores logicos dentro de lo que comprenden las fechas)";
        String pieDePrograma = "\n" + "=".repeat(50) + "\n\t\t\tFIN DEL PROGRAMA\n" + "=".repeat(50);
        String preguntaEjecucion = "\nDesea ingresar una nuevo Numero? | (1) SI | (2) NO | ---> ";

        System.out.println(encabezado);
        do {

            System.out.println(instrucciones);
            dia1 = leerDia(input, "Ingrese un dia: ");
            mes1 = leerMes(input, "Ingrese un mes: ");
            anio1 = leerAnio(input, "Ingrese un año: ");
            int[] fecha1 = {dia1, mes1, anio1};
            String fecha1String = formatearFecha(fecha1);
            System.out.println("Fecha: " + fecha1String + " ingresada exitosamente.");
            dia2 = leerDia(input, "Ingrese otro dia: ");
            mes2 = leerMes(input, "Ingrese otro mes: ");
            anio2 = leerAnio(input, "Ingrese otro anio: ");
            int[] fecha2 = {dia2, mes2, anio2};
            String fecha2String = formatearFecha(fecha2);
            System.out.println("Fecha: " + fecha2String + " ingresada exitosamente.");

            compararFechas(fecha1, fecha2,fecha1String,fecha2String);

            run = Validador.continuacionDelPrograma(input, preguntaEjecucion);

        } while (run);

        input.close();
        System.out.println(pieDePrograma);
    }

    public static int leerDia(Scanner input, String mensaje){
        while (true) {
            int dia = Validador.leerEntero(input, mensaje);
            if (dia>=1 && dia<=30) return dia;
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
            if (anio >= 1 && anio <=100000) return anio;
            else System.out.println("ERROR: El anio ingresado debe estar entre 1 y 100000.");
        }
    }

    public static String formatearFecha(int[] fecha){
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
        return (fecha[0] + " de " + nombreMes[fecha[1]-1] + " del año " + fecha[2]);
    }

    public static void compararFechas(int[] fecha1, int[] fecha2, String fecha1S, String fecha2S){

        long diferencia;

        long cant1 = (fecha1[2]* 360L) + (fecha1[1]* 30L) + fecha1[0];
        long cant2 = (fecha2[2]* 360L) + (fecha2[1]* 30L) + fecha2[0];

        if (cant1 > cant2) {
            diferencia = cant1 - cant2;
        }  else if  (cant1 < cant2) {
            diferencia = cant2 - cant1;
        }  else diferencia = 0;

        if (diferencia == 0) {
            System.out.println("Las fechas son iguales");
            return;
        }

        System.out.println("La distancia entre " + fecha1S + " y " + fecha2S + " es de: " + diferencia + " dias.");


    }
}
