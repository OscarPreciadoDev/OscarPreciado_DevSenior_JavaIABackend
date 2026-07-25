package model;


// Declaración de un objeto de clase cliente (Una futura entidad)
public class Cliente {

    // Cada cliente contará con los siguientes atributos privados
    private int id;
    private String nombre;
    private String email;
    private String ciudad;

    // Constructor de un objeto de clase Cliente
    public Cliente(int id, String nombre, String email, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.ciudad = ciudad;
    }

    // Constructor con otra firma
    public Cliente(String nombre, String email, String ciudad) {
        this.nombre = nombre;
        this.email = email;
        this.ciudad = ciudad;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getCiudad() { return ciudad; }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre
                + "', email='" + email + "', ciudad='" + ciudad + "'}";
    }
}