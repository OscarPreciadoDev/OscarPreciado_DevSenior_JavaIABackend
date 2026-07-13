package Ejemplos2;

// Clase padre

public class Animal {

    // Atributos

    protected String nombre;

    // Constructor

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    // Metodos

    public String hacerSonido(){
        return("Sonido generico");
    }
}
