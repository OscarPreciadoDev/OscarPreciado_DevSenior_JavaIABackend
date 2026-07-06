/*  OPERACIONES
    Es donde vive el producto, y donde pasan las cosas: registrarlo, verlo, actualizarlo, calcular, su valor.
    
    Para guardar el producto usamos variables static dentro de la clase: son la memoria de la app mientras el programa corre. Agregamos una bandera hayProducto (un boolean) para saber si ya se registro algo*/

import java.util.Scanner;

public class Operaciones {

    static final int MAX = 50;
    static String[] nombres = new String[MAX];
    static int[] cantidades = new int[MAX];
    static double[] precios = new double[MAX];
    static int total = 0;
    // static boolean hayProducto = false;


    public static void registrar(Scanner sc){

        if (total == MAX) {
            System.out.println("Inventario Lleno. No se pueden agregar mas productos.");
            return;
        }
        nombres[total] = Validador.leerTexto(sc, "Nombre del producto: ");
            cantidades[total] = Validador.leerEntero(sc, "Cantidad: ");
            precios[total] = Validador.leerDecimal(sc, "Precio unitario: ");
            total++;
            System.out.println("Producto registrado correctamente.");
        }

    public static void listar(){
    if (total == 0) {
        System.out.println("Aun no hay proudctos registrados.");
        return;
    }
    System.out.println("*** INVENTARIO ***");
        for(int i = 0 ; i < total; i++) {
            System.out.println((i + 1 ) +". " + nombres[i]
                    + " | cant: " + cantidades[i]
                    + " | precio: " + precios[i]);
        }
    }

    public static void actualizarCantidad(Scanner sc) {
        if (total == 0) {
            System.out.println("Aun no hay productos registrados.");
            return;
        }
        listar();
        int pos = Validador.leerEntero(sc, "Numero del producto a actualizar: ");
        if (pos < 1 || pos > total ) {
            System.out.println("Ese numero no existe en el inventario.");
        }
        cantidades[pos-1] = Validador.leerEntero(sc, "Nueva cantidad: ");
        System.out.println("Cantidad actualizada.");
    }

    public static void verValorTotal(){
        if (total == 0) {
            System.out.println("Aun no hay productos registrados.");
            return;
        }
        double suma = 0;
        for (int i = 0; i < total ; i++) {
            suma = suma + (cantidades[i] * precios[i]);
        }
        System.out.println("Valor total del inventario: " + suma);
    }

}
