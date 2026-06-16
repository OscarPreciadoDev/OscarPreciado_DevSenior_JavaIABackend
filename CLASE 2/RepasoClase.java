import java.util.Scanner;

public class RepasoClase {
    public static void main(String args[]){
// crear nombre, edad, estatura

    String nombre;
    int edad;
    double estatura;

    Scanner entrada = new Scanner(System.in);

    //nombre = "Oscar";
    //edad = 22;
    //estatura = 1.70;

    System.out.println(">> Ingrese su nombre: ");
    nombre = entrada.nextLine();

    System.out.println(">> Ingrese su edad: ");
    edad = entrada.nextInt();

    System.out.println(">> Ingrese su estatura en metros: ");
    estatura = entrada.nextDouble();

    System.out.println(">> Nombre: "+nombre);
    System.out.println(">> Edad: "+edad);
    System.out.println(">> Estatura: "+estatura+" m");
    }
}

// Public hace referencia al punto de acceso
//  