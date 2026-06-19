/*
    Demuestra if
*/


public class IfDemostracion {
    public static void main(String args[]){
        int a,b,c;

        a = 2;
        b = 3;

        if(a<b) System.out.println(">> a es menor que b");

        //esto no despliega nada
        if(a>b) System.out.println("> a es mayor que b");

        System.out.println();

        c = a-b; // c contiene -1

        System.out.println(">> c contiene -1");

        if(c>=0) System.out.println(">> c no es negativo");
        if(c<0) System.out.println(">> c es negativo");

        System.out.println();

        c = b - a; // c contiene ahora 1 

        System.out.println(">> c contiene 1");

        if(c>=0) System.out.println(">> c no es negativo");
        if(c<0) System.out.println(">> c es negativo");


    }
}
