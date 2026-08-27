package com.myTestRassept.gestor_productos.model;                           // Ubicación de la clase

import jakarta.persistence.*;                                               // Librerías utilizadas en esta clase
import java.util.ArrayList;
import java.util.List;
import static jakarta.persistence.GenerationType.*;

@Entity                                                                     // Anotación que indica que esto es una tabla en BD
@Table(name = "categorias")                                                 // Nombre a dar en la tabla en BD
public class Categoria {                                                    // Inicio de la clase

    // DECLARACION DE ATRIBUTOS (TODOS PRIVADOS)

    @Id                                                                     // Anotacion que indica que este es el PK en BD
    @GeneratedValue(strategy = IDENTITY)                                    // Manera de generar el @id
    private Long id;                                                        // Atributo que pasara a ser id

    private String nombre;                                                  // Atributo que pasara a columna de tabla

    @OneToMany(mappedBy = "categoria")                                      // Relacion de categoria (1 - M) productos
    private List<Producto> productos = new ArrayList<>();                   // Atributo que pasara a ser columna de productos

    // DECLARACION DE CONSTRUCTORES (PUBLICOS)

    public Categoria() {}                                                   // Constructor vacio solicitado por JPA/Hibernate

    public Categoria(Long id, String nombre, List<Producto> productos) {    // Constructor completo con los atributos correspondientes.
        this.id = id;
        this.nombre = nombre;
        this.productos = productos;
    }

    // GETTERS Y SETTERS (PUBLICOS)

    public Long getId() {                                                   // Getter de ID
        return id;
    }

    public void setId(Long id) {                                            // Setter de ID
        this.id = id;
    }

    public String getNombre() {                                             // Getter de Nombre
        return nombre;
    }

    public void setNombre(String nombre) {                                  // Setter de nombre
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {                                  // Getter de productos
        return productos;
    }

    public void setProductos(List<Producto> productos) {                    // Setter de productos
        this.productos = productos;
    }
}