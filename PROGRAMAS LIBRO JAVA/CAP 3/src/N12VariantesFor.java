// Bucle hasta que se escribe S.

import java.util.Scanner;

public class N12VariantesFor {
    public static void main(String[] args) {
        
        int i;
        Scanner sc = new Scanner(System.in);
        char ch =  ' ';

        System.out.println("Imprima S para detener");

        for (i=0; ch != 'S' ; i++){
            System.out.print("Paso #"+i+" :");
            ch = sc.nextLine().charAt(0);
        }  
        sc.close();
    }
}
