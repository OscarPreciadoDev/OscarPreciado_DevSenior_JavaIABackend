package model;


// Declaración de un objeto de clase Miembro (Una futura entidad)
public class Miembro {

    // Cada miembro contará con los siguientes atributos privados
    private int id;
    private String nombre;
    private String email;
    private String plan;

    // Constructor de un objeto de clase Miembro
    public Miembro(int id, String nombre, String email, String plan) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.plan = plan;
    }

    // Constructor con otra firma
    public Miembro(String nombre, String email, String plan) {
        this.nombre = nombre;
        this.email = email;
        this.plan = plan;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getPlan() { return plan; }

    @Override
    public String toString() {
        return "Miembro{id=" + id + ", nombre='" + nombre
                + "', email='" + email + "', plan='" + plan + "'}";
    }
}
