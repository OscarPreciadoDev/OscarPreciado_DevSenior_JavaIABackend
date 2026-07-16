public class Ej04ReturnDemo {

    // esta clase tiene un metodo que despliega un listado hasta 4

    void miMetodo(){
        int i;

        for (i = 0 ; i <= 5 ; i ++ ) {
            if (i == 5) return;
            System.out.println(i);
        }
    }

    // Metodo principal

    public static void main(String[] args) {

        // Se crea un objeto de la clase creada
        Ej04ReturnDemo ejemplo = new Ej04ReturnDemo();

        // Se invoca el metodo
        ejemplo.miMetodo();
    }
}
