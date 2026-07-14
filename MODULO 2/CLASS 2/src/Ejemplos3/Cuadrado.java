package Ejemplos3;

// Clase hija

class Cuadrado extends Figura {

    // Esta clase tiene un tamaño de lado, será su atributo

    public double lado;

    // El constructor de cuadrado recibe el tamaño del lado

    public Cuadrado(int lado){
        this.lado = lado;
    }

    // sobreescribe el metodo de calcular área, bajo la logica para cuadrado

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}