

public class Operadores {
    
    public static void main(String args[]){

        int a,b,suma,resta,multiplicacion,modulo;
        double division;
        a = 5;
        b = 10;


        suma = a+b;
        System.out.println(">> 5 + 10 = "+suma);

        resta = a-b;
        System.out.println(">> 5 - 10 = "+resta);

        multiplicacion = a*b;
        System.out.println(">> 5 x 10 = "+multiplicacion);
        
        // casteo (double) ya que la respuesta da decimal 1/2
        division = (double)a/b;
        System.out.println(">> 5 / 10 = "+division);

        // Modulo = Residuo de la division
        modulo = a % b;
        System.out.println(">> 5 % 10 = "+modulo);
    }

}
