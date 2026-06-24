public class N16PromocionByteAInt {
    public static void main(String[] args) {
        
        byte b;
        int i;

        b = 10;
        i = b * b; // OK, no se necesita modelado

        b = 10;
        b = (byte) (b*b); // Se necesita modelado (el resultado dara un int, entonces se necesita un modelado para devolverlo a byte)

        System.out.println("i y b: " + i + " " + b );

    }
}
