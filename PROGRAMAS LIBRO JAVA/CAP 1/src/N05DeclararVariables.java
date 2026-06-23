/*
El siguiente programa crea dos variables llamadas var1 y var2

>> Esto demuestra una variable

*/

public class N05DeclararVariables {
    public static void main(String argsp[]){
        int var1; // esto declara una variable
        int var2; // esto declara otra variable

        var1 = 1024; // esto asigna 1024 a var1

        System.out.println("var1 contiene :" + var1); // Imprime en consola mensaje 

        var2 = var1/2; // Asigna a var1 la operacion matematica de la instancia

        System.out.print("var2 contiene var1 / 2: "); // Imprime en consola mensaje
        System.out.println(var2); // Imprime en consola mensaje
    }
}
