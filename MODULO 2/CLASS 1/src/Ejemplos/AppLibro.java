package Ejemplos;

public class AppLibro {
    public static void main(String[] args) {
        Libro libro1 =  new Libro(); // Llama a la clase para construr un objeto de la clase.
        // Definir los atributos de libro1
        libro1.titulo = "Clean Code";
        libro1.autor = "Robert Martin";
        libro1.paginas = 464;
        // Llamar el metodo descripcion de la clase
        System.out.println(libro1.descripcion());
    }
}
