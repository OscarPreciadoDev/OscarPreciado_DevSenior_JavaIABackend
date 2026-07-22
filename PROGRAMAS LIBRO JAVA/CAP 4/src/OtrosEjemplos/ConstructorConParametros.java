package OtrosEjemplos;

public class ConstructorConParametros {
    public static void main(String[] args) {
        ClaseZ ejemplo = new ClaseZ(10);
        ClaseZ ejemplo2 =  new ClaseZ(40);

        System.out.println("El atributo z en la instancia \"ejemplo\" tiene un valor de: " + ejemplo.z);
        System.out.println("El atributo z en la instancia \"ejemplo2\" tiene un valor de: " + ejemplo2.z);
    }
}

class ClaseZ {
    int z;

    ClaseZ(int i){ // El constructor tiene un parametro (i) que se asignara a (z)
        z = i;
    }
}
