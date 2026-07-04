public class Main {
    public static void main(String[] args) {

        Perro miPerro = new Perro();
        miPerro.nombre = "Firulais";
        miPerro.raza = "Labrador";
        miPerro.ladrar();
        System.out.println();

        Perro otroPerro = new Perro();
        otroPerro.nombre = "Rocky";
        otroPerro.ladrar();
        System.out.println();

/*
        Libro libro = new Libro();
        libro.titulo = "Clean Code";
        libro.autor = "Robert Martin";
        libro.paginas = 464;
        System.out.println(libro.descripcion());
        System.out.println();
*/

        Libro miLibro = new Libro();
        miLibro.setTitulo("TituloPrueba");
        miLibro.setPaginas(200);
        miLibro.setAutor("Shaekspear");

        String descripcion = miLibro.toString();
        System.out.println(descripcion);

        Producto productoPrueba = new Producto("Papa",500);
        productoPrueba.mostrar();
        System.out.println();

        Producto vacio = new Producto();
        vacio.mostrar();
        System.out.println();


    }
}
