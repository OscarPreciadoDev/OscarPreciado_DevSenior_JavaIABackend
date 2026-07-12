package cuentaBancariaUpper;

public class Cliente {

    private String nombre;
    private String documento;
    private String telefono;

    public Cliente() {
        this.nombre = "Sin asignar";
        this.documento = "0000";
        this.telefono = "0000";
    }

    public Cliente(String nombre, String documento, String telefono) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String toString() {
        return "Cliente: " + nombre + " | Documento: " + documento + " | Telefono: " + telefono;
    }
}
