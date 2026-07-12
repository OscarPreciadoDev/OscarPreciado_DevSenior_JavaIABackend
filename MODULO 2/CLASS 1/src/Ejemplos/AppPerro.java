package Ejemplos;

public class AppPerro {
    public static void main(String[] args) {
        Perro perroEjemplo = new Perro();       // Se llama a la clase 'Ejemplos.Perro' Para crear un objeto de esta clase
        perroEjemplo.nombre = "Naia";           // Se asignan los atributos creados con los argumentos dados
        perroEjemplo.raza = "Cocker spaniel";   // Se asignan los atributos creados con los argumentos dados
        perroEjemplo.ladrar();                  // Se llama al metodo creado en la clase

        Perro otroPerro = new Perro();
        otroPerro.nombre = "Rookie";
        otroPerro.raza = "Pitbull";
        otroPerro.ladrar();
    }

}
