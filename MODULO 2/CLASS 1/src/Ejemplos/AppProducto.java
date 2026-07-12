package Ejemplos;

public class AppProducto {
    public static void main(String[] args) {

        // Crear un objeto de la clase Producto usando el constructor vacio.
        Producto productoVacio = new Producto();
        productoVacio.mostrar();

        // Crear un objeto de la clase Producto usando el constructor con parametros.
        Producto cafe = new Producto("Cafe" , 15000);
        cafe.mostrar();
    }
}
