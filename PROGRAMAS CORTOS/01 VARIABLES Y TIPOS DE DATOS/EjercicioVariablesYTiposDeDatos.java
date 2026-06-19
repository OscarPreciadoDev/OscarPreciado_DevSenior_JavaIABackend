// Script para introduccion a tipos de datos con uso de la terminal

//Importar una libreria para recoger entrada de la terminal
import java.util.Scanner;

public class EjercicioVariablesYTiposDeDatos {
    
    public static void main(String[] args) throws Exception {

        // Declarar una variable de cada tipo de dato visto
        int edad;
        double salario;
        float promedio;
        char sexo;
        boolean estado;
        String nombres;

        // Crear un objeto scaner que lea desde la entrada de terminal

        Scanner entrada = new Scanner(System.in);

        System.out.println("> Ingrese su edad: ");
        edad = entrada.nextInt();

        System.out.println("> Ingrese su salario: ");
        salario = entrada.nextDouble();

        System.out.println("Ingrese su promedio de estudiante: ");
        promedio = entrada.nextFloat();

        System.out.println("Ingrese su genero (Hombre: H,  Mujer: M):");
        sexo = entrada.next().charAt(0);

        System.out.println("Ingrese true/false segun sea su estado actual: ");
        estado = entrada.nextBoolean();
        entrada.nextLine(); // consumir Enter

    System.out.println("Ingrese su nombre: ");
    nombres = entrada.nextLine();

        System.out.println("> Datos del usuario:\n> Nombre: " + nombres + "\n> Edad: " + edad + "\n> Salario: " + salario + "\n> Promedio: " + promedio + "\n> Genero: " + sexo + "\n> Estado: " + estado);

        entrada.close();
        

        
    }
}
