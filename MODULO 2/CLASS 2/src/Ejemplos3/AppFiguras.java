package Ejemplos3;

public class AppFiguras {

    public static void main(String[] args) {
        Figura[] figuras = {
                new Circulo(2),
                new Rectangulo(3,4),
                new Cuadrado(5)
        };

        for (Figura f : figuras ) {
            System.out.printf("Area: %.2f%n" ,  f.calcularArea());
        }
    }

}
