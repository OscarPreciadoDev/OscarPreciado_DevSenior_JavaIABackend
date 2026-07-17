package EjemploFactor;

public class AppFactor {

    public static void main(String[] args) {
        Factor factor = new Factor();

        int num1 = 3, num2 = 6;


        if (factor.esFactor(num1,num2)){
            System.out.println("El numero " + num1 + " es factor de " + num2);
        } else {
            System.out.println("El numero " + num1 + " no es factor de " + num2);
        }

    }

}
