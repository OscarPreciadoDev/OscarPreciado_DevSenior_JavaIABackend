package com.myTestRassept.gestor_productos.model;                   // Ubicación de la clase.

import jakarta.persistence.*;                                       // Librerías utilizadas en esta clase.

@Entity                                                             // Anotación que indica que esto es una tabla en BD.
@Table(name = "productos")                                          // Nombre a dar en la tabla en BD.
public class Producto {                                             // Inicio de la clase.

    // DECLARACION DE ATRIBUTOS (TODOS PRIVADOS)

    @Id                                                             // Anotacion que indica que este es el PK en BD.
    @GeneratedValue(strategy = GenerationType.IDENTITY)             // Manera de generar el @id.
    private Long id;                                                // Atributo que pasara a ser id.

    private String nombre;                                          // Atributo que pasara a columna de tabla.
    private String descripcion;                                     // Atributo que pasara a columna de tabla.
    private double precio;                                          // Atributo que pasara a columna de tabla.
    private int stock;                                              // Atributo que pasara a columna de tabla.

    @ManyToOne                                                      // Tipo de relacion de la sigueinte columna en la tabla (Categoria [1 - M]) Productos).
    @JoinColumn(name = "categoria_id")                              // Ingresa la FK categoria_id (de la tabla categoria).
    private Categoria categoria;                                    // Atributo-columna donde se inyecta la FK.

    @ManyToOne                                                      // Tipo de relacion del siguiente atributo en la tabla (Marca [1 - M]) Productos).
    @JoinColumn(name = "marca_id")                                  // Ingresa la FK categoria_id (de la tabla categoria).
    private Marca marca;                                            // Atributo-columna donde se inyecta la FK.

    // CONSTRUCTORES (PUBLICOS)

    public Producto() {}                                            // Constructor vacio solicitado por JPA/Hibernate.

    public Producto(Long id,                                        // // Constructor completo con los atributos correspondientes.
                    String nombre,
                    String descripcion,
                    double precio,
                    int stock,
                    Categoria categoria,
                    Marca marca) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.marca = marca;
    }

    // DECLARACION DE GETTERS Y SETTERS (No tienen mayor explicacion, ver la dada en model/Categoria.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}