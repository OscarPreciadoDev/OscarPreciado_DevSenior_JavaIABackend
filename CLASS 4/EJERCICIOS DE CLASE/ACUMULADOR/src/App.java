// ## ACUMULADOR

//  Pide 4 precios al usuario, guardalos en un array y muestra el promedio

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        final int MAX = 4;
        double[] precios = new double[MAX];

        System.out.println("*** ACUMULADOR ****");
        System.out.println("Ingrese a continuacion 4 precios.");
        for(int i = 0 ; i < MAX ; i++){
            precios[i] = ValidadorDecimal(sc, "Ingrese un precio: ");
        }

        double promedio = calcularPromedio(precios);
        System.out.println("El promedio de los precios ingresados es: " + promedio);
    }

    public static double ValidadorDecimal(Scanner sc, String mensaje){
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()){
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            }
            else{
                System.out.println("Valor ingresado invalido, intente nuevamente.");
                sc.nextLine();
            }
        }
    }

    public static double calcularPromedio(double[] array){
        double sum = 0;

        for (int i = 0; i < array.length ; i++ ){
            sum += array[i];
        }

        double promedio = sum / array.length;
        return promedio;
    }
}
