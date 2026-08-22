package com.myTestRassept.gestor_productos.model;


// Definición de la clase producto
public class Producto {

    // Atributos de clase, son privados.
    private int id;
    private String nombre;
    private double precio;

    // Constructor vacío (Debe dejarse para que Spring funcione sin problema).
    public Producto() {
    }

    // Constructor principal (Constructor de negocio).
    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getter de ID.
    public int getId() {
        return id;
    }

    // Setter de ID.
    public void setId(int id) {
        this.id = id;
    }

    // Getter de nombre.
    public String getNombre() {
        return nombre;
    }

    // Setter de nombre.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter de precio.
    public double getPrecio() {
        return precio;
    }

    // Setter de precio.
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
