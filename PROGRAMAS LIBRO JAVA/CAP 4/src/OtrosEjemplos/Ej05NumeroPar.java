package OtrosEjemplos;// Un ejemplo simple en el que se utiliza un parametro

class RevNum{
    // devuelve true si x es par
    boolean esPar(int x){
        return ((x%2) == 0);
    }
}

class parametrosDemostracion {
    public static void main(String[] args) {

        RevNum rev = new RevNum();

        if (rev.esPar(10)) {
            System.out.println("El numero es par");
        }
        else {
            System.out.println("El numero no es par");
        }
    }
}