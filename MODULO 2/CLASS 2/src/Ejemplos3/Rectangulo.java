package Ejemplos3;

public class Rectangulo extends Figura {

    // Atributos

    private double base, altura;

    // Constructor

    public Rectangulo (double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Metodo abstracto heredado (necesita declaración)

    @Override
    public double calcularArea() {
        return base * altura;
    }
}
