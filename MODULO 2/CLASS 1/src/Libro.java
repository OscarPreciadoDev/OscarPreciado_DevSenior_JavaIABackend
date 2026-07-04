public class Libro {

    private String titulo;
    private String autor;
    int paginas;

    //! Constructor vacio tiene el mismo nombre de la clase
    public Libro() {
    }

    // Setters y getters


    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", paginas=" + paginas +
                '}';
    }

    String descripcion() {
        return titulo + " de " + autor + " (" + paginas + " paginas)";
    }
}
