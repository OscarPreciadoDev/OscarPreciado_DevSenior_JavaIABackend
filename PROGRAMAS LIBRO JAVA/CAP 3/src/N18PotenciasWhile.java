// Este programa calcula las potencias enteras de 2 usando un bucle while

public class N18PotenciasWhile {

    public static void main(String[] args) {
        int e;
        int result;

        for (int i = 1; i < 10; i++){
            result = 1;
            e = i;
            while (e > 0) {
                result *= 2;
                e--;
            }

            System.out.println("2 a la " + i + " potencia es " + result);
        }
    }

}
