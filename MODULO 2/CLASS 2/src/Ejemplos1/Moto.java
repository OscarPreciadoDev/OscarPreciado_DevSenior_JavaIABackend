package Ejemplos1;

// La clase Moto tiene relación de padre hija


// Extends índica la relación de herencia con vehículo
public class Moto extends Vehiculo {

    public Moto(String marca) {
        super(marca);
    }

    // Metodo que tendrá ella, pero no la clase padre, propia de las Motos
    public void hacerCaballito() {
        System.out.println(marca + " hace un caballito.");
    }
}
