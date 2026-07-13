package Ejemplos1;

// La clase Vehículo tiene relación de clase padre

public class Vehiculo {

    // Atributos que heredara a la clase hija
    protected String marca;             // Protected inidica que las clases hijas tiene acceso a estos atributos
    protected int velocidad;

    // Metodos que heredara a la clase hija
    public Vehiculo(String marca){
        this.marca =  marca;
        this.velocidad = 0;
    }

    public void acelerar() {
        velocidad +=10;
        System.out.println(marca + " acelera a " + velocidad + " km/h");
    }
}
