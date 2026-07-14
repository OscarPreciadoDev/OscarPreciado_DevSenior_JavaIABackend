// Este programa demuestra el uso del bucle do While, se solicita entrada por teclado un caracter, y se repetira hasta que el usuario ingrese 'g'

import java.util.Scanner;

public class N19DoWhile {
    public static void main(String[] args){
        char ch;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Imprima una tecla y luego presione ENTER: ");
            ch = sc.next().charAt(0);

        } while ( ch != 'g');

        sc.close();
    }
}
