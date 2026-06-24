// Demuestra los operadores de cortocircuito 


public class N11OperadoresCortocircuito {

    public static void main(String[] args) {
        int n, d;

        n = 10;
        d = 2;

        if (d!= 0 && (n % d ) == 0)
            System.out.println(d + " es un factor de " + n);
        
        d = 0; // ajofa, fije d en cero

        // Como d es cero, el segundo operando no se evalua

        if (d!= 0 && (n % d ) == 0)                         // <==== El operador de corto circuito esta evitando una visiion entre 0
            System.out.println(d + " es un factor de " + n);
        
        /*
        Ahora, intente lo mismo sin el operador de cortocircuito.
        Esto causara un error de division entre cero
        */

        if (d!=0 & (n % d) == 0 )                           // <==== Ahora se evaluan ambas expresiones, donde se ejecutara la divisio que dara error
            System.out.println(d + " es un factor de " + n);

    }
}
