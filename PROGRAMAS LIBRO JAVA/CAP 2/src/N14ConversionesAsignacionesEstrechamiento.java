public class N14ConversionesAsignacionesEstrechamiento {
    public static void main(String[] args) {
        
        double x, y;

        byte b;
        int i;
        char ch;

        x = 10.0;
        y = 3.0;

         i = (int) (x/y) ; // Moldea double a int
        System.out.println("Salida de entero de x / y : " + i);

        i = 100;
        b = (byte) i; // Moldea int a byte. (No hay perdida de informacion aqui. Un byte puede contener el valor 100.)
        System.out.println("Valor de b: " + b);

        i = 257;
        b = (byte) i; // Moldea int a byte. (Se pierde informacion. Un byte no puede contener el valor de 257)
        System.out.println("Valor de b : " + b);

        b = 88; // condigo ASCII para x
        ch = (char) b; // Moldea byte a char (Moldeado entre tipos incompatibes)
        System.out.println("ch: " + ch);
        }
}
