package Ejemplos2;

// Clase padre

public class Animal {

    // Atributos

    protected String nombre;

    // Constructor

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    // metodos

    public String hacerSonido(){
        return("sonido genérico");
    }
}
