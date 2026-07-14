package Ejemplos3;

public class Circulo extends Figura {

    // Atributos
    private double radio;


    // Constructor

    public Circulo(double radio) {
        this.radio = radio;
    }

    // Metodo abstracto heredado (necesita declaración)

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}
