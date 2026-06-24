// Demuestra los operadores relacionales y logicos.

public class N10OperadoresRelacionalesLogicos {

    public static void main(String[] args) {
        int i,j;
        boolean b1,b2;

        i = 10;
        j = 11;

        if (i < j) System.out.println("i < j");
        if (i <= j) System.out.println("i <= j");
        if (i != j) System.out.println("i != j");
        if (i == j) System.out.println("Esto no se ejecuta");
        if (i > j) System.out.println("Esto no se ejecuta");
        

        b1 = true;
        b2 = false;

        if (b1&b2) System.out.println("Esto no se ejecuta");
        if (!(b1&b2)) System.out.println("!(b1 & b2) es verdadero");
        if (b1 | b2) System.out.println("b1 | b2 es verdadero");
        if (b1 ^ b2) System.out.println("es verdadero");
    }

}
