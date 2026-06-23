// Demuestra el alcance del bloque

public class N06AlcanceDemostracion {
    public static void main(String[] args) {
        
        int x;              // Conocido a todo el codigo en main

        x = 10;             

        if (x==10) {        // Inicia un nuev alcance
            int y = 20;     // conocido solo a este bloque

                            // (x,y) son conocidos aqui
            System.out.println("x y y : " + x + " " + y);
        }

        // y = 100;         // Error. "y" no es conocido aqui

        // x aun es conocido aqui
        System.out.println("x es " + x);
    }    


}
