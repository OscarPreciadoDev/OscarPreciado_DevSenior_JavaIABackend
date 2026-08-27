package com.myTestRassept.gestor_productos.model;                   // Ubicacion de la clase.

import jakarta.persistence.*;                                       // Librerías utilizadas en esta clase.

@Entity                                                             // Anotación que indica que esto es una tabla en BD.
@Table(name = "marcas")                                             // Nombre a dar en la tabla en BD.
public class Marca {                                                // Inicio de la clase.

    // DECLARACION DE ATRIBUTOS (PRIVADOS)

    @Id                                                             // Anotacion que indica que este es el PK en BD.
    @GeneratedValue(strategy = GenerationType.IDENTITY)             // Manera de generar el @id.
    private Long id;                                                // Atributo que pasara a ser id.

    private String nombre;                                          // Atributo que pasara a columna de clase.

    // DECLARACION DE CONSTRUCTORES (PUBLICOS)

    public Marca() {}                                               // Constructor vacio solicitado por JPA/Hibernate.

    public Marca(Long id, String nombre) {                          // Constructor completo con los atributos correspondientes.
        this.id = id;
        this.nombre = nombre;
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
}