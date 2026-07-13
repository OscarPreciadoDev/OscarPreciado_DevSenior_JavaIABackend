package AppUsuarios;

// Clase padre, esta ahora es abstracta

public abstract class Usuario {

    // Atributos

    protected String nombre;
    protected String email;

    // Constructor

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    // Getters

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    // Metodo genérico de panel de usuario. Luego cada clase lo sobreescribirá
    // Además será abstracto, no tiene un cuerpo

    public abstract String panelInicio();

    @Override
    public String toString() {
        return (nombre + " < " + email + " >");
    }
}
