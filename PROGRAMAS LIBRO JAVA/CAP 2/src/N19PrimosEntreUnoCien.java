// Escriba un programa que encuentre todos los numeros primos entre 1 y 100

public class N19PrimosEntreUnoCien {
    public static void main(String[] args) {
    
    System.out.println("Numeros primos del 1 al 100");
    int num;

    for(num = 0; num <=100; num++){

        if(EsPrimo(num)){
            System.out.print(num + " ");
        } else {
            //System.out.println(num + "\t No");
        }
    }
}

        
    public static boolean EsPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        for (int divisor = 2; divisor*divisor <=numero ; divisor++) {
            if (numero % divisor == 0) {
                return false;
            }
        }
    return true;
    }
}

