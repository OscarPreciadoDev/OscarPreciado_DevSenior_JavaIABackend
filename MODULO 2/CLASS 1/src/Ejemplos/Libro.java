package Ejemplos;

public class Libro {
    String titulo;          // Atributo
    String autor;           // Atributo
    int paginas;            // Atributo

    String descripcion(){   // Metodo
        return titulo + " de " + autor + " (" + paginas + " paginas)";
    }
}