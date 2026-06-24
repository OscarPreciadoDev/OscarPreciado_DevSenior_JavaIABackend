/*En este proyecto creara un programa que despliegue latabla de verdad de los 
operadores logicos de Java. Debe hacer que las columnas de la tabla esten alineadas.
En este progrecto se utilizaran varias de las funciones vistas del modulo. 
Incluidas las secuencias de escape de Java y los operadores logico. Tambien
se ilustran las diferencias respecto a la precedencia entre el operador aritmetico + 
y los operadores logicos */

public class N15OpLogicTabla {
    public static void main(String[] args) {
        
        boolean p,q;

        System.out.println("P\tQ\tY\tO\tXO\tNO (P)");

        p = true; q = true;
        System.out.print(p + "\t" + q + "\t");
        System.out.print((p&q) + "\t" + (p|q) + "\t");
        System.out.println((p^q) + "\t" + !p);

        p = true; q = false;
        System.out.print(p + "\t" + q + "\t");
        System.out.print((p&q) + "\t" + (p|q) + "\t");
        System.out.println((p^q) + "\t" + !p);

        p = false; q = true;
        System.out.print(p + "\t" + q + "\t");
        System.out.print((p&q) + "\t" + (p|q) + "\t");
        System.out.println((p^q) + "\t" + !p);

        p = false
        
        ; q = false;
        System.out.print(p + "\t" + q + "\t");
        System.out.print((p&q) + "\t" + (p|q) + "\t");
        System.out.println((p^q) + "\t" + !p);
    }
}
