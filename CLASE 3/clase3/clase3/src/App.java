import java.util.Scanner; // Se importa la libreria de Java que da el Scanner

public class App {
    public static void main(String[] args) throws Exception {


        /*
            EXPLICACION DE SCANNER
            =============================================================
        */
        
        Scanner sc = new Scanner(System.in);

        // Scanner = Clase
        // NombreClase = Nombre de la entrada Scanner
        // new Scanner = Crea una instancia de la clase Scanner
        // System.in = Ingreso de informacion por teclado

        System.out.println(">> Cuantas personas en la mesa? "); // Impresion en consola
        int personas = sc.nextInt(); // Asigna a la variable la entrada de Numero Entero

        sc.nextLine(); // Consume un salto de linea del Buffer

        System.out.println(">> Nombre del cliente: "); // Impresion en consola
        String nombre = sc.nextLine(); // Asigna a la variable la entrada de String solicitada

        System.out.println(">> Mesa de " + nombre + ", " + personas + " personas."); // Print formateado con los datos ingresados

        sc.close(); // Cerrar la entrada de scanner

        /*
            EXPLICACION DE OPERADORES LOGICOS
            =============================================================
        */

        double subtotal = 20000;
        boolean tieneCupon = true;

        boolean aplicaDescuento = subtotal > 100000 && tieneCupon;

        System.out.println(">> Aplica descuento? " + aplicaDescuento);

        /*
            CONVERSION DE DATOS EXPLICITA Y IMPLICITA
            =============================================================
        */

        // Convertir un Int a un Decimal

        int unidades = 5;
        double comoDecimal = unidades; // 5.0
        System.out.println(">> Implicita: " + comoDecimal);

        // Convertir un Decimal a un Int

        double precio = 19990.75;
        int precioRecortado = (int) precio;
        System.out.println(">> Casting: " + precioRecortado); // 19990

    }
}
