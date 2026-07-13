package Ejemplos3;

// Ejemplo explicativo del abstraction, No existe una figura a secas
// Se define una clase abstracta y sus metodos también son abstractos
// Cada figura hija tiene que definir sus propios metodos

// Clase padre

public abstract class Figura {
    public abstract double CalcularArea(); // El metodo es abstracto y obliga a las clases hijas a definirlo

}

