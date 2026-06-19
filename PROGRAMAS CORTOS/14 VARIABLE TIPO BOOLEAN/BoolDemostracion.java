public class BoolDemostracion {
    public static void main(String[] args) {
        
        boolean b;

        b = false;

        System.out.println(">> b es : "+b);

        b = true;

        System.out.println(">> b es : "+b);

        // un valor boolena puede controlar la instruccion if

        if(b) System.out.println(">> Esto se ejecuta.");

        b = false;

        if(b) System.out.println(">> Esto no se ejecuta.");

        // La salida de un operador relacional es un valor boolean
        System.out.println(">> 10 > 9 es : "+(10>9));

    }
}
