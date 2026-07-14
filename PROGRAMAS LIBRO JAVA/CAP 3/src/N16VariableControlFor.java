// El siguiente programa calcular la sumatoria y el factorial de 1 a 5 y declara su variable de control del bucle i dentro del for

public class N16VariableControlFor {
    public static void main(String[] args) {
        int suma = 0;
        int fact = 1;

        // calcular el factorial de los numeros hasta el 5

        for (int i = 1; i <= 5; i++){
            suma += i;
            fact *= i;
        }

        // pero i no se conoce aqui

        System.out.println("La suma es " + suma);
        System.out.println("El factorial es " + fact);
    }

}
