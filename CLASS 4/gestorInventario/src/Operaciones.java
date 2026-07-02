/*  OPERACIONES
    Es donde vive el producto, y donde pasan las cosas: registrarlo, verlo, actualizarlo, calcular, su valor.
    
    Para guardar el producto usamos variables static dentro de la clase: son la memoria de la app mientras el programa corre. Agregamos una bandera hayProducto (un boolean) para saber si ya se registro algo*/

import java.util.Scanner;

public class Operaciones {

    static String nombre = "";
    static int cantidad = 0;
    static double precio = 0.0;
    static boolean hayProducto = false;

    
    public static void registrar(Scanner sc){
        nombre = Validador.leerTexto(sc, "Nombre del producto: ");
        cantidad = Validador.leerEntero(sc, "Cantidad: ");
        precio = Validador.leerDecimal(sc, "Precio unitario: ");
        hayProducto = true;
        System.out.println("Producto registrado correctamente.");
    }

/* VER PRODUCTO

Primer revisamos con un if si ya hay un producto. Si no, avisamo y salimos del metodo con return
eso evitara mostrar datos vacios*/

    public static void ver(){
        if (!hayProducto) {
            System.out.println("Aun no hay ningun producto registrado.");
            return;
        }
        System.out.println("Producto: " + nombre);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio: " + precio);
    }

/*  ACTUALIZAR CANTIDAD Y VER TOTAL

"actualizar cantidad" cambia solo la cantidad (cuando llega o se vende mercancia) "VerValorTotal" multiplica cantidad por precio: la pregunta de negocio. Cuanto vale lo que tengo?

 */

    public static void actualizarCantidad(Scanner sc){
        if(!hayProducto) {
            System.out.println("Aun no hay ningun producto registrado.");
            return;
        }
        cantidad = Validador.leerEntero(sc, "Nueva cantidad:");
        System.out.println("Cantidad actualizada.");
    }

    public static void verValorTotal() {
        if(!hayProducto){
            System.out.println("Aun no hay ningun producto registrado.");
        }
        double total = cantidad * precio;
        System.out.println("Valor total en inventario: " + total);
    }
}
