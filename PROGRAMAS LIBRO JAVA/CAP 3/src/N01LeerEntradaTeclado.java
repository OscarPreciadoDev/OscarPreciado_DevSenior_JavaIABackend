//Leer un caracter del teclado

public class N01LeerEntradaTeclado {
    public static void main(String[] args) throws Exception {
        
        char ch;

        System.out.print("~~ Oprima una tecla seguida de ENTER:");

        ch = (char) System.in.read(); // Obtiene un char

        System.out.println("~~ Su tecla es: " + ch);
    }
}
