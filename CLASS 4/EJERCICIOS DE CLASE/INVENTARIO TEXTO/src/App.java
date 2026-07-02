// ## Mini Inventario de texto

// Un array de 3 nombres de productos. Recorrelo y muestra cada uno numerado (1,2,3).

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        final int MAX = 3;
        String[] productos = new String[MAX];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i<MAX ;i++){
            System.out.print("Ingrese un producto: ");
            productos[i] = sc.nextLine();
        }
        sc.close();

        for (int i=0; i<MAX;i++){
            System.out.println((i+1)+ ". " + productos[i]);
        }
    }
}
