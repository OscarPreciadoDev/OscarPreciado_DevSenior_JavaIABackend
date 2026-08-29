package com.myTestRassept.gestor_productos.dto;

import com.myTestRassept.gestor_productos.model.Producto;

public class ProductoDTO {

    // Atributos que debe tener la clase, estos son iguales a los que debe tener el model original

    private Long id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;
    private String marca;

    // Constructor

    public ProductoDTO(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.precio = producto.getPrecio();
        this.stock = producto.getStock();

        // Indica que los campos correspondientes a las FK no pueden estar vacios

        this.categoria = producto.getCategoria() != null
                ? producto.getCategoria().getNombre() : null;
        this.marca = producto.getMarca() != null
                ? producto.getMarca().getNombre() : null;
    }

    public String getMarca() {
        return marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

}