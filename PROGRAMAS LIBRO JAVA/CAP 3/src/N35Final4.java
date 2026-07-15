/*
Escriba un programa que use un bucle for para generar y desplegar la progresión 1,2,4,8,16,32 ...
 */

public class N35Final4 {
    public static void main(String[] args) {
        for (int i = 1 ; i < 100; i += i ) {
            System.out.println(i);
        }
    }
}
