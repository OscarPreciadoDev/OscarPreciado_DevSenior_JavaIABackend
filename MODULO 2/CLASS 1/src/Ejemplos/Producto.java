package Ejemplos;

public class Producto {
    String nombre;      // Atributo
    double precio;      // Atributo

    Producto(){         // Constructor vacio, asigna argumentos por default
        this.nombre="Sin nombre";
        this.precio=0.0;
    }

    Producto(String nombre,  double precio){ // Constructor con parametros
        this.nombre = nombre; // Aquí se usa this para asegurar que haga referencia al atributo
        this.precio = precio;
    }

    void mostrar(){
        System.out.println(nombre + " --> $" + precio);
    }
}

