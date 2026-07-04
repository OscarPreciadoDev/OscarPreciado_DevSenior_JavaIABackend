import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        int edad;
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("*** VALIDADOR DE EDAD ***");
            edad = ValidadorEntero(sc, "Ingrese su edad: ");
            if (edad > 0 && edad < 150){
                System.out.println("La edad ingresada (" + edad + ") es valida. Bienvenido!!");
                break;
            }
            else {
                System.out.println("La edad ingresada no esta dentro de un rango real [0 a 150]");
                System.out.println("Intente nuevamente.");
            }
        }
        System.out.println("Fin del programa.");
        
    }

    public static int ValidadorEntero(Scanner sc, String mensaje){

        while(true){
            System.out.print(mensaje);
            if (sc.hasNextInt()){
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            }
            else{
                System.out.println("El dato ingresado no es un numero entero. Intente nuevamente");
                sc.nextLine();
            }
        }  
    }
}
