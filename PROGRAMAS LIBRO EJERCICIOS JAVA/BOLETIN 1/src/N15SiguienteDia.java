/*
Pedir el día, mes y año de uan fecha correcta y mostrar la fecha del día siguiente. Suponer que todos los meses tienen 30 días.
 */

import java.util.Scanner;

public class N15SiguienteDia {
    public static void main(String[] args){

        boolean run = true;
        Scanner input = new Scanner(System.in);
        int dia,mes,anio;

        String encabezado ="=".repeat(50)+"\n\t\t\tSIGUIENTE DIA\n"+"=".repeat(50);
        String instrucciones ="\nIngrese un dia, un mes y un año para ver el siguiente dia.\n(debe ingresar valores logicos dentro de lo que comprenden las fechas)";
        String pieDePrograma ="\n"+"=".repeat(50)+"\n\t\t\tFIN DEL PROGRAMA\n"+"=".repeat(50);
        String PreguntaEjecucion ="\nDesea ingresar una nuevo Numero? | (1) SI | (2) NO | ---> ";

        System.out.println(encabezado);
        do {

            System.out.println(instrucciones);
            dia = leerDia(input, "Ingrese un dia: ");
            mes = leerMes(input, "Ingrese un mes: ");
            anio = leerAnio(input, "Ingrese una año: ");

            imprimirSiguienteDia(dia,mes,anio);

            run = Validador.continuacionDelPrograma(input,PreguntaEjecucion);

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

    public static void imprimirSiguienteDia(int dia,int mes,int anio){
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

        if (dia == 30) {
            dia = 1;
            mes +=1;
        } else dia +=1;

        if (mes == 13) {
            mes = 1;
            anio +=1;
        };

        System.out.println(dia + " / " + nombreMes[mes-1] + " / " + anio);

    }

}
