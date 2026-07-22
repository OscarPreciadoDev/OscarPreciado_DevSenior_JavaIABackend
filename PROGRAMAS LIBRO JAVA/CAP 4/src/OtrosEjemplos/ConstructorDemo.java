package OtrosEjemplos;

public class ConstructorDemo {

    public static void main(String[] args){
        MiClase t1 = new MiClase();
        MiClase t2 = new MiClase(); // Se usa el constructor y por defecto el atributo x se asigna a 10

        System.out.println(t1.x + " " + + t2.x); // Demostración en consola que imprimirá "10 10"
    }

}

class MiClase {
    int x;

    MiClase(){
        x = 10; // Define por default ese atributo a 10.
    }
}
