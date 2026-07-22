import java.util.Scanner;

public class N16SiguienteDiaUpper {
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

            if(validarFecha(dia,mes)){
                imprimirSiguienteDia(dia,mes,anio);
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

        if (mes == 2 ) {
            if (dia == 28) {
                dia = 1;
                mes += 1;
            } else dia +=1;
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
            if (dia == 30){
                dia = 1;
                mes += 1;
            }  else dia +=1;
        }
        if (mes == 13){
            mes = 1;
            anio += 1;
        }

        System.out.println(dia + " / " + nombreMes[mes-1] + " / " + anio);

    }

    public static void  errorFecha(int dia,int mes){
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
        if (mes == 2 ){
            System.out.println("El mes de febrero solo tiene 28 dias.");
        } else if (mes == 4 || mes ==  6 || mes == 9 || mes == 11) {
            System.out.println("El mes de " + nombreMes[mes-1] + " solo tiene 30 dias.");
        }
    }

    public static boolean validarFecha(int dia,int mes){
        if (mes == 2 && dia > 28) return false;
        else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) return false;
        else return true;
    }

}
