import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3){
            Menu.llamarMenu();
            opcion = Menu.tomarOpcion(sc);

            switch (opcion) {
                case 1:
                    System.out.println("Ha tomado la eleccion 1");
                    break;
                case 2:
                    System.out.println("Ha tomado la eleccion 2");
                    break;
                case 3:
                    System.out.println("Ha tomado la eleccion 3");
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Debe ingresar un numero entre 1 y 3, intente nuevamente");
                    break;
            }
        }
        sc.close();
    }
}


