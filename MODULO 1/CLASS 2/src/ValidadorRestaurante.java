/*
    El programa pide los datos, calcula propina y total, aplica el descuento solo si se cumplen las 2 condiciones, y reparte entre las personas

    CONDICIONES: 
    
    1. Pedir datos : Cuenta (decimal), numero de personas (entero) y si es cliente freciente (nextboolean())

    2. Calcular : Propina (10%) y total

    3. Aplicar logica : Si es cliente freciente Y la cuenta supera los 100.000 aplica 5% de descuento sobre el total

    4. Repartir Dividir el total final entre las personas y mostrar todo con mensajes claros
*/

import java.util.Scanner;

public class ValidadorRestaurante {
    
    public static void main(String[] args) {

        double descuento = 0;
        
        Scanner sc = new Scanner(System.in);

        System.out.println(">> Ingrese el monto de la cuenta: ");
        double cuenta = sc.nextDouble();

        System.out.println(">> Ingrese el total de personas: ");
        int personas = sc.nextInt();

        sc.nextLine();

        System.out.println(">> Ingrese el nombre del titular para la cuenta: ");
        String nombre = sc.nextLine();

        System.out.println(">> Sr/a "+nombre+" es usted un cliente frecuente? ");
        boolean clienteFrecuente = sc.nextBoolean();
        
        double propina = cuenta * 0.1;
        double total = cuenta + propina ;

        if((cuenta>100000) && clienteFrecuente) descuento = total *0.05;

        double cuentaFinal = total - descuento;

        double porPersona = cuentaFinal / personas;

        System.out.println(">> FACTURA DE CONSUMO: ");
        System.out.println(">> Gracias por su consumo Sr/a "+nombre);
        System.out.println(">> Resumen del consumo:");
        System.out.println(">> Cliente frecuente: "+ clienteFrecuente);
        System.out.println(">> Cuenta : "+ cuenta);
        System.out.println(">> Servicio del 10% : " + propina);
        System.out.println(">> Total sin descuento : "+total);
        System.out.println(">> Descuento: "+ descuento);
        System.out.println(">> Total de la cuenta: " +cuentaFinal);
        System.out.println(">> Monto a pagar entre ("+personas+") personas: " + porPersona);

        
        sc.close();

        }

    }

